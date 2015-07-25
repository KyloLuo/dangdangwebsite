package com.eagle.dangdang.product.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*目录级别类
 * 一个目录包括对象含有父目录和一群子目录
 * 
 * +-------------+--------------+------+-----+---------+----------------+
 | Field       | Type         | Null | Key | Default | Extra          |
 +-------------+--------------+------+-----+---------+----------------+
 | id          | int(12)      | NO   | PRI | NULL    | auto_increment |
 | turn        | int(10)      | NO   |     | NULL    |                |
 | en_name     | varchar(200) | NO   |     | NULL    |                |
 | name        | varchar(200) | NO   |     | NULL    |                |
 | description | varchar(200) | YES  |     | NULL    |                |
 | parent_id   | int(10)      | YES  |     | NULL    |                |
 +-------------+--------------+------+-----+---------+----------------+
 * */

@Entity
@Table(name = "D_CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	@NotBlank(message = "目录的名称不能为空")
	private String name;

	@Column(name = "en_name")
	private String enName;

	@Column(name = "description")
	private String description;

	@Column(name = "level")
	private int level;

	@ManyToOne(cascade = { CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "parent_id")
	@JsonIgnore
	private Category parentCategory;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "parentCategory")
	private Set<Category> categories = new HashSet<Category>(0);

	//@OneToMany(cascade={CascadeType.MERGE})
	//@JoinTable(name = "D_CATEGORY_BOOK", joinColumns = { @JoinColumn(name = "category_id") }, inverseJoinColumns = { @JoinColumn(name = "book_id") })
	@ManyToMany(targetEntity=Book.class)
	@JsonIgnore
	private Set<Book> books = new HashSet<Book>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", enName=" + enName
				+ ", description=" + description + ", level=" + level + "]";
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
