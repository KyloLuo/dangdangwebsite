package com.eagle.dangdang.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/*书籍类商品*/
/*+----------------+--------------+------+-----+---------+-
| Field          | Type         | Null | Key | Default |
+----------------+--------------+------+-----+---------+-
| id             | int(12)      | NO   | PRI | NULL    |
| author         | varchar(200) | NO   |     | NULL    |
| publishing     | varchar(200) | NO   |     | NULL    |
| publish_time   | bigint(20)   | NO   |     | NULL    |
| word_number    | varchar(15)  | YES  |     | NULL    |
| which_edtion   | varchar(15)  | YES  |     | NULL    |
| total_page     | varchar(15)  | YES  |     | NULL    |
| print_time     | int(20)      | YES  |     | NULL    |
| print_number   | varchar(15)  | YES  |     | NULL    |
| isbn           | varchar(25)  | YES  |     | NULL    |
| author_summary | text         | NO   |     | NULL    |
| catalogue      | text         | NO   |     | NULL    |
+----------------+--------------+------+-----+---------+-
 * 
 */

@Entity
@Table(name="D_BOOK")
@PrimaryKeyJoinColumn(name="product_id")
public class Book extends Product{
	
	@Column(name="author",nullable=false)
	private String author;
	
	@Column(name="publishing",nullable=false)
	private String publishing;
	
	@Column(name="publisth_time",nullable=false)
	private Date publishTime;
	
	@Column(name="word_number")
	private String wordNumber;
	
	@Column(name="which_edition")
	private String whichEdition;
	
	@Column(name="total_page")
	private int totalPage;
	
	@Column(name="print_time")
	private int printTime;
	
	@Column(name="print_num")
	private int printNum;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="author_summary")
	@Type(type="text")
	private String authorSummary;
	
	@Column(name="catalogue")
	@Type(type="text")
	private String catalogue;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getWordNumber() {
		return wordNumber;
	}

	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	public String getWhichEdition() {
		return whichEdition;
	}

	public void setWhichEdition(String whichEdition) {
		this.whichEdition = whichEdition;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	

	public int getPrintTime() {
		return printTime;
	}

	public void setPrintTime(int printTime) {
		this.printTime = printTime;
	}

	public int getPrintNum() {
		return printNum;
	}

	public void setPrintNum(int printNum) {
		this.printNum = printNum;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorSummary() {
		return authorSummary;
	}

	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", publishing=" + publishing
				+ ", publishTime=" + publishTime + ", wordNumber=" + wordNumber
				+ ", whichEdition=" + whichEdition + ", totalPage=" + totalPage
				+ ", printTime=" + printTime + ", printNum=" + printNum
				+ ", isbn=" + isbn + ", authorSummary=" + authorSummary
				+ ", catalogue=" + catalogue + "]";
	}
	
	
	
	
	
	

}
