package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Data//getter,setter을 동시에 만듬
//@AllArgsConstructor//생성자를 만들고 싶을때
//@RequiredArgsConstructor//final붙은 애들에 대한 constructor를 만들어 준다.
@NoArgsConstructor//빈 생성자
public class Member {
	//private final int id;
	//private final String username;
	//private final String password;//변경할 일이 없을 경우에만 final을 붙힌다. 만약 변경해야하면 붙히면 안됨
	//private final String email;
	private  int id;
	private  String username;
	private  String password;//변경할 일이 없을 경우에만 final을 붙힌다. 만약 변경해야하면 붙히면 안됨
	private  String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
		
}
