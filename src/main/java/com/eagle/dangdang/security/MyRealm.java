package com.eagle.dangdang.security;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.eagle.dangdang.user.entity.User;
import com.eagle.dangdang.user.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Resource(name="userService")
	private UserService userService;

	private static final Logger logger = LogManager.getLogger(MyRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		return  null;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		logger.info("authenticate is invoked ");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		AuthenticationInfo authcInfo = null;// 验证信息
		User user =userService.authenticate(token.getUsername(), new String(token.getPassword()));
		System.out.println(new String(token.getPassword()));
		if(user==null){
			throw new AuthenticationException();
		}else{
			authcInfo = new SimpleAuthenticationInfo(user.getId(),
					user.getPassword(), getName());
			this.setSession("currentUser", user);
			return authcInfo;
		}

	}

	/**
	 * ShiroSession设置
	 * 
	 * @see 使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public static Logger getLogger() {
		return logger;
	}


}
