package com.eagle.dangdang.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.dangdang.user.entity.User;
import com.eagle.dangdang.user.service.UserService;
import com.eagle.dangdang.util.Constant;
import com.eagle.dangdang.util.MD5Util;
import com.eagle.dangdang.util.VerifyUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserServiceTest {

	@Resource
	private UserService userService;

	// @Test
	public void testFindUserByEmail() {
		System.out.println(userService.findUserByEmail("978364051@qq.com"));
	}

	@Test
	public void testAuthenticate() {
		User user=null;
		try {
			user = userService.authenticate("978364051@qq.com", MD5Util.encode("dpc123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
	}

	/**
	 * 
	 2015年7月18日
	 */
	// @Test
	public void testAddUser() {
		User user = new User();
		user.setEmail("79812641@qq.com");
		try {
			user.setPassword(MD5Util.encode("dpc123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setUserIntegral(Constant.INTEGRAL_NORMAL);
		user.setEmailVerifyCode(VerifyUtil.randomUUID());
		user.setLastLoginTime(new Date(System.currentTimeMillis()));
		user.setLastLoginIp("127.0.0.1");
		user.setNickname("逆天斩月");
		user.setEmailVerify(true);

		userService.addUser(user);
		System.out.println(user);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
