package com.eagle.dangdang.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/*商品父类 
 * 持有所有商品共有的属性
 * */

/*+--------------+--------------+------+-----+---------+
 | id           | int(12)      | NO   | PRI | NULL    |
 | product_name | varchar(100) | NO   |     | NULL    |
 | description  | varchar(100) | YES  |     | NULL    |
 | add_time     | bigint(20)   | YES  |     | NULL    |
 | fixed_price  | double       | NO   |     | NULL    |
 | dang_price   | double       | NO   |     | NULL    |
 | keywords     | varchar(200) | YES  |     | NULL    |
 | has_deleted  | int(1)       | NO   |     | 0       |
 | product_pic  | varchar(200) | YES  |     | NULL    |
 +--------------+--------------+------+-----+---------+
 */

@Entity
@Table(name = "D_PRODUCT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="product_name",nullable=false)
	private String productName;
	
	@Column(name="add_time")
	private Date addTime;
	
	@Column(name="fixed_price")
	private double fixedPrice;
	
	@Column(name="dang_price")
	private double dangPrice;
	
	@Column(name="keywords")
	private String keywords;
	
	@Column(name="has_deleted")
	private boolean hasDeleted;// 是否已经下架
	
	@Column(name="product_pic")
	private String productPic;

	public Product(){}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public double getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public double getDangPrice() {
		return dangPrice;
	}

	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean isHasDeleted() {
		return hasDeleted;
	}

	public void setHasDeleted(boolean hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	
	
}
