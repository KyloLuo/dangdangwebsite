package com.eagle.dangdang.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author dpc
 *  用户对应的后货地址实体类 一个用户可以对应多个不同的收货地址
 */

/**
 * --------------+--------------+------+-----+-------- id | int(12) | NO | PRI |
 * NULL user_id | int(11) | NO | | NULL receive_name | varchar(20) | NO | | NULL
 * full_address | varchar(200) | NO | | NULL postal_code | varchar(8) | NO | |
 * NULL mobile | varchar(15) | YES | | NULL phone | varchar(20) | YES | | NULL
 *
 */

@Entity
@Table(name = "D_RECEIVE_ADDRESS")
public class ReceiveAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "receive_name", length = 20)
	@NotBlank(message = "收货人姓名不能为空")
	private String receiveName;

	@Column(name = "full_address")
	@NotBlank(message = "收货地址不能为空")
	private String fullAddress;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(name = "mobile")
	@Pattern(regexp = "^13\\d{9}|14[57]\\d{8}|15[012356789]\\d{8}|18[01256789]\\d{8}|170\\d{8}$", message = "手机号码不符合格式")
	private String mobile;

	@Column(name = "phone")
	private String phone;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true)
	private User user;
	
	public ReceiveAddress(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ReceiveAddress [id=" + id + ", receiveName=" + receiveName
				+ ", fullAddress=" + fullAddress + ", postalCode=" + postalCode
				+ ", mobile=" + mobile + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((receiveName == null) ? 0 : receiveName.hashCode());
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
		ReceiveAddress other = (ReceiveAddress) obj;
		if (id != other.id)
			return false;
		if (receiveName == null) {
			if (other.receiveName != null)
				return false;
		} else if (!receiveName.equals(other.receiveName))
			return false;
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
