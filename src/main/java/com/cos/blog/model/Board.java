package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {

	@Id//Pirmary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto-increment
	private int id;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob//대용량 데이터
	private String content;//섬머노트 라이브러리 <html>테그가 섞여서 디자인이 됨

	@ColumnDefault("0")
	private int count;//조회수
	
	@ManyToOne//Many=Board(Many) User=One 연관 관계를 맺어 준다.한명의 user는 여러 글을 쓸수있다.
	@JoinColumn(name="userId")//실제 db에는 userId로 저장된다.
	private User user;//db는 오브젝트를 저장 할 수 없다.fk, 자바는 오브젝트를 저장할 수 있다.
	
	@CreationTimestamp//시간이 자동으로 입력
	private Timestamp createDate;

}
