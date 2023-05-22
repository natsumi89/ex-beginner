package com.example.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class User {
	@NotBlank(message="名前は必須です")
	private String name;
	@NotBlank(message="年齢は必須です")
	@Pattern(regexp="[0-9]{1,3}$",message="3桁までの数字で入力してください")
	private Integer age;
	@NotBlank(message="コメントは必須です")
	private String comment;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
