package com.eagle.dangdang.user.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eagle.dangdang.user.entity.User;
import com.eagle.dangdang.user.service.UserService;
import com.eagle.dangdang.util.Constant;
import com.eagle.dangdang.util.MD5Util;
import com.eagle.dangdang.util.VerifyUtil;

/*用户管理模块的controller*/
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	private UserService userService;

	@Resource(name = "mailSender")
	private JavaMailSenderImpl mailSender;

	private static final Logger logger = LogManager
			.getLogger(UserController.class);

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "/login";// 跳转到用户的登陆页面
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@ModelAttribute("email") String email,
			@ModelAttribute("password") String password,
			HttpServletRequest request) throws Exception {
		logger.info("begin login prepared to authenticate");
		// 配置用户名和口令
		UsernamePasswordToken token = new UsernamePasswordToken(email,
				MD5Util.encode(password));
		try {
			SecurityUtils.getSubject().login(token);// 执行用户验证
			// 跟新用户的ip和loginTime信息
			User user = (User) SecurityUtils.getSubject().getSession()
					.getAttribute("currentUser");
			user.setLastLoginTime(new Date(System.currentTimeMillis()));
			String ip = getRemoteHost(request);
			user.setLastLoginIp(ip);
			userService.updateUser(user);// 持久化
		} catch (AuthenticationException e) {
			logger.info("用户名或密码不正确");
			return "login_failure"; // 带错误结果返回登陆页面
		}
		return "login_success";// 登陆成功跳转到主页面
	}

	@RequiresAuthentication
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "";// 返回到商品显示的主页面
	}

	/* 注册相关的处理 */
	// 注册步骤: 1.填写信息 > 2.验证邮箱 > 3.注册成功

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User();
		model.addAttribute("userForm", user);
		return "user/register_form";// 显示用户注册的界面
	}

	// 注:验证码存在于session中，通过访问CodeController可以获得当前用户session中存在的验证码信息
	// 对验证码正确性的判断存在于js中，通过异步请求获得，不再controller中进行判断

	// 通过email查找该邮箱是否已经注册过
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean isUserExist(
			@ModelAttribute("email") String email) {
		System.out.println(email);
		User user = userService.findUserByEmail(email);
		if (user != null)
			return true;
		else
			return false;
	}

	// 执行添加用户的操作,并准备开始邮箱验证
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(User user, HttpSession session) {
		try {
			// 设置用户为未验证状态
			user.setEmailVerify(false);
			// 为用户密码进行加密
			user.setPassword(MD5Util.encode(user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 开始发送邮件，提供用户验证码，并将生成的验证码存入session供调用
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		// 设置用户的邮件地址
		email.setTo(user.getEmail());
		// 设置邮件的主题
		email.setSubject("测试邮件发送");
		// 设置邮件的发送账户
		email.setFrom(Constant.EMAIL_ACCOUNT);

		// 获得随机的验证码，并存入session
		String verifyCode = VerifyUtil.randomUUID();
		user.setEmailVerifyCode(verifyCode);

		// 设置要发送的邮件中的验证信息内容
		email.setText(getEmailText(verifyCode));

		// sends the e-mail
		mailSender.send(email);
		User temp = userService.addUser(user);
		session.setAttribute("user_register", temp);
		return "user/verify_form";
	}

	// 验证
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String doVerify(@ModelAttribute("verifyCode") String verifyCode,
			Model model, HttpSession session) {
		// session中取出登陆的用户对象,比较输入和用户的验证码是否一致
		User user = (User) session.getAttribute("user_register");
		if (user.getEmailVerifyCode().equals(verifyCode)) {
			user.setEmailVerify(true);
			userService.updateUser(user);// 持久化
			session.removeAttribute("user_register");//移除session对象，释放资源
			// 验证成功，提示注册成功
			return "user/verify_ok";
		} else {
			// 验证失败，退回验证页面
			model.addAttribute("verify_msg", "验证码不正确");
			return "user/verify_form";
		}
	}

	// 直接跳转到，验证页面的请求
	@RequestMapping(value = "/verify_form")
	public String beginVerify(Model model) {
		return "user/verify_form";
	}

	public String getEmailText(String verifyCode) {
		StringBuilder text = new StringBuilder("验证码为:");
		text.append(verifyCode);
		text.append("\n点击链接进行邮箱验证:\n");
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String ip = addr.getHostAddress();// 获得本机IP
		String link = "http://" + ip + ":8080/dangdang/user/verify_form";
		text.append(link);
		return text.toString();
	}

	// 获取请求的客户端的真是ip地址（使用了代理也能获得）
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

}
