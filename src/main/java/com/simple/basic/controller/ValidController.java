package com.simple.basic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {
	
	@RequestMapping("/ex01")
	public String ex01() {
		
		return "valid/ex01";
	}
	
	//@Valid - 유효성검사 진행, Errors - 유효성검사에 실패하면 에러객체로 바인딩
	@PostMapping("/actionForm")
	public String actionForm(@Valid ValidVO vo, Errors error) {
		
		System.out.println(vo.toString());
		
		System.out.println(error.getErrorCount());
		
		return "valid/ex01_result";
	}

}
