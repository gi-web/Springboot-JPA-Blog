package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

//ORM->Java(다른언어) object->테이블로 매핑해주는 기술
//여기서 변수명을 변경하면 db테이블의 컬럼명이 자동으로 변경된다.
@Entity//테이블 생성을 위한 어노테이션 user클래스가 mariadb에 테이블이 생성 된다.
public class User {

	@Id//Pirmary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//프로젝트에서 연결된 넘버링 전략을 따라간다.
	private int id;//시퀀스(oracle),auto-increment(mysql) 자동증가
	
	@Column(nullable=false, length=30)//username는 null이 될수 없고 30자 이상 될수없다.
	private String username;//id

	@Column(nullable=false, length=100)//1234=>해쉬(비밀번호 암호화)
	private String password;

	@Column(nullable=false, length=50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role;//Enum(도메인(범위)을 줄수있어서)을 쓰는게 좋다. admin,user,manager에 따라 권한을 줄수있다. 
	
	@CreationTimestamp//시간이 자동으로 입력
	private Timestamp createDate;
}
