package com.example.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
@Override
	public String toString() {
		return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}
@NotBlank(message="名前を入力してください")
private String name;
@NotBlank(message="年齢を入力してください")
private String age;
@NotBlank(message="コメントを入力してください")
private String comment;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}

}
