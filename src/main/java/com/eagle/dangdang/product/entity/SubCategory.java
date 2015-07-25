package com.eagle.dangdang.product.entity;

/* 为了方便json传输的 子目录类*/
public class SubCategory {

	private long id;
	private String name;
	private String enName;
	private int level;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public SubCategory() {
		super();
	}

}
