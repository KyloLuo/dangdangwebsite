package com.eagle.dangdang.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eagle.dangdang.product.entity.Product;

/**
 * 
 * @author dpc
 * 订单的条目类
 *+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | int(12)      | NO   | PRI | NULL    | auto_increment |
| order_id     | int(10)      | NO   |     | NULL    |                |
| product_id   | int(10)      | NO   |     | NULL    |                |
| product_name | varchar(100) | NO   |     | NULL    |                |
| dang_price   | double       | NO   |     | NULL    |                |
| product_num  | int(10)      | NO   |     | NULL    |                |
| amount       | double       | NO   |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="D_ORDERLINE")
public class OrderLine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;
	
	
	@Column(name="product_num",nullable=false)
	private int productNum;
	
	@Column(name="amount")
	private double amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OrderLine() {
		super();
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", product=" + product + ", productNum="
				+ productNum + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderLine other = (OrderLine) obj;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
}