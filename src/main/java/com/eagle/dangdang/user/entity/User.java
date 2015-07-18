package com.eagle.dangdang.user.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author dpc 对应的用户类实体
 */

/*
 * id | int(12) | NO email | varchar(50) | NO nickname | varchar(50) | YES
 * password | varchar(50) | NO user_integral | int(12) | NO is_email_verify |
 * char(3) | YES email_verify_code | varchar(50) | YES last_login_time |
 * bigint(20) | YES last_login_ip | varchar(15) | YES
 */

@Entity
@Table(name = "D_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="email",unique=true,nullable=true,updatable=false)
	@Email(message="邮箱的格式不正确")
	private String email;
	
	@Column(name="nickname",length=20)
	private String nickname;
	
	@Column(name="password",nullable=false)
	@NotBlank
	private String password;
	
	@Column(name="user_integral")
	private int userIntegral;
	
	@Column(name="is_email_verify")
	private boolean isEmailVerify;
	
	
	@Column(name="email_verify_code")
	private String emailVerifyCode;
	
	@Column(name="last_login_time")
	private Date lastLoginTime;
	
	@Column(name="last_login_ip")
	private String lastLoginIp;

	@OneToMany(cascade={CascadeType.ALL},mappedBy="user")
	Set<ReceiveAddress> address=new HashSet<ReceiveAddress>();
	
	public User() {

	}

	public Set<ReceiveAddress> getAddress() {
		return address;
	}

	public void setAddress(Set<ReceiveAddress> address) {
		this.address = address;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}

	public boolean isEmailVerify() {
		return isEmailVerify;
	}

	public void setEmailVerify(boolean isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname
				+ ", password=" + password + ", userIntegral=" + userIntegral
				+ ", isEmailVerify=" + isEmailVerify + ", emailVerifyCode="
				+ emailVerifyCode + ", lastLoginTime=" + lastLoginTime
				+ ", lastLoginIp=" + lastLoginIp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
