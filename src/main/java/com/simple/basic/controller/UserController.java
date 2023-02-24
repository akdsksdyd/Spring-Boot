package com.simple.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.UsersVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		
		return "user/login";
	}
	
	//로그인기능
	@PostMapping("/login")
	public String loginForm(UsersVO vo, HttpSession session) {
		
		//select * from 유저 where id = ? and pw = ?
		
		//서비스영역 호출 (로그인 성공)
		
		UsersVO userVO = new UsersVO();
		userVO.setId("aaa");
		userVO.setName("홍길동");
		
		//로그인 성공 - 세션을 이용해서 인증값
		if(userVO != null) {
			session.setAttribute("user_id", userVO.getId()); //토큰
			return "redirect:/user/mypage"; //로그인 성공
		}
		
		
		return "user/login"; //로그인 실패
	}
	
	//특정 유저들만 접근 할 수 있는 페이지
	@GetMapping("/mypage")
	public String mypage(/*HttpSession session*/) {
		
		//세션검사 -
		/* 세션검사 해 줄 페이지가 적을 땐 하나씩 해도 되지만 페이지가 많다면 번거롭기 때문에 필터나 인터셉터를 사용
		if(session.getAttribute("user_id") == null) {
			return "redirect:/user/login";
		}
		*/
		System.out.println("컨트롤러 실행됨");
		
		return "user/mypage";
	}
	
	//특정 유저들만 접근 할 수 있는 페이지
	@GetMapping("/info")
	public String info() {
		
		return "user/info";
	}
	
}


















