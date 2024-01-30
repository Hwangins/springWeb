package com.springWeb.module.user.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springWeb.module.user.service.UserService;
import com.springWeb.util.AuthenticationUtil;

@Controller
public class UserController {
	
	// 인증번호의 자릿수
	private final int NUMBER_OF_DIGITS = 6;
	
	
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * 로그인 (페이지 이동)
	 * */
	@RequestMapping(value = "/user/login-page")
	public String loginPage(HttpServletRequest request
	         			 , HttpServletResponse response
			             , @RequestParam Map<String, Object> param 
			             , Model model){
		
		model.addAttribute("msg", "회원가입 페이지 이동");
		
		return "/user/login";
	}
	
	/**
	 * 회원가입 (페이지 이동)
	 * */
	@RequestMapping(value = "/user/join-page")
	public String joinPage(HttpServletRequest request
	         			 , HttpServletResponse response
			             , @RequestParam Map<String, Object> param 
			             , Model model){
		
		model.addAttribute("msg", "회원가입 페이지 이동");
		
		return "/user/join";
	}
	
	/**
	 * 회원가입
	 * */
	@ResponseBody
	@RequestMapping(value = "/user/join")
	public String join(HttpServletRequest request
			         , HttpServletResponse response
			         , @RequestParam Map<String, Object> param 
			         , Model model){
		
		String resultMsg = "가입되었습니다.";
		
		return resultMsg;
	}
	
	/**
	 * 회원가입 (인증번호 발급)
	 * */
	@RequestMapping(value = "/user/join/auth-code", produces="application/json;charset=utf8")
	@ResponseBody
	public String generateAuthCode(HttpServletRequest reqeust
			 					 , HttpServletResponse response
			 					 , @RequestParam Map<String, Object> param
			 					 , ModelMap model){
		
		String authCode = AuthenticationUtil.generateAuthCode(NUMBER_OF_DIGITS);
		String msg = "";
		
		try {
			param.put("authCode", authCode);
			userService.insertAuthCode(param);
			msg = "인증 번호가 발급되었습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "인증 번호 발급에 실패하였습니다.";
		}
		
		return msg;
	}
}
