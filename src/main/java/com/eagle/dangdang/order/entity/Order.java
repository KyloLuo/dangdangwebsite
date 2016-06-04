package com.eagle.dangdang.order.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.entity.User;

/**
 * 
 * @author dpc
 * 订单的实体类
 *+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | int(10)      | NO   | PRI | NULL    | auto_increment |
| user_id      | int(10)      | NO   |     | NULL    |                |
| status       | int(10)      | NO   |     | NULL    |                |
| order_time   | bigint(20)   | NO   |     | NULL    |                |
| order_desc   | varchar(100) | YES  |     | NULL    |                |
| total_price  | double       | NO   |     | NULL    |                |
| receive_name | varchar(100) | YES  |     | NULL    |                |
| full_address | varchar(200) | YES  |     | NULL    |                |
| postal_code  | varchar(8)   | YES  |     | NULL    |                |
| mobile       | varchar(20)  | YES  |     | NULL    |                |
| phone        | varchar(20)  | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
 */

@Entity
@Table(name="d_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="status",nullable=false)
	private String status;
	
	@Column(name="order_time")
	private Date orderTime;
	
	@Column(name="order_desc")
	private boolean orderDesc;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<OrderLine> orderLines=new HashSet<OrderLine>(0);
	
	@Column(name="total_price")
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private ReceiveAddress address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public boolean isOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(boolean orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ReceiveAddress getAddress() {
		return address;
	}

	public void setAddress(ReceiveAddress address) {
		this.address = address;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderTime="
				+ orderTime + ", orderDesc=" + orderDesc + ", orderLines="
				+ orderLines + ", totalPrice=" + totalPrice + ", user=" + user
				+ ", address=" + address + "]";
	}
	
	
	
	
}