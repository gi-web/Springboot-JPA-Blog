package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//인터넷 브라우저 요청은 get요청밖에 할 수 없다.
//사용자요청시 응답(html) 일경우 @Controller사용
//사용자 요청시 응답(data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG="HttpControllerTest: ";
	
	//http://localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "ssar", "1234", "email");//@AllArgsConstructor가 작용
		Member m =  Member.builder().username("ssar").password("1234").email("ssar@naver.com").build();
		System.out.println(TAG+"getter: "+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"setter: "+m.getUsername());
		//Member m2=new Member();//@NoArgsConstructor가 작용
		return "lombok test 완료";
	}
	
	
	//http://localhost:8000/blog/http/get(select)
	@GetMapping("/http/get")
	//public String getTest(@RequestParam int id, @RequestParam String username) {
	public String getTest(Member m) {	//MessageConverter(스프링부트)가 제이슨을 파싱해준다.
		return "get요청: " +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8000/blog/http/post(insert)
	@PostMapping("/http/post")//text/plain,application/json
	public String postTest(@RequestBody Member m) {//MessageConverter(스프링부트)가 제이슨을 파싱해준다.
		return "post 요청:" +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8000/blog/http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put요청:" +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8000/blog/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
   
	
}
