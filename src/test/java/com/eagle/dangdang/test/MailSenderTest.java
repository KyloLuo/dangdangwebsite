package com.eagle.dangdang.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MailSenderTest {
	
	@Resource(name="mailSender")
	private JavaMailSenderImpl mailSender;

	@Test
	public void testSendSimpleEmail(){
		 // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("798728019@qq.com");
        email.setSubject("测试邮件发送");
        email.setText("ceshi");
        email.setFrom("978364051@qq.com");
        // sends the e-mail
        mailSender.send(email);
	}

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
	
	
}
