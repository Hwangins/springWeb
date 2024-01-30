package com.springWeb.module.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springWeb.module.member.service.MemberService;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping("/member/list")
	public String selectMemberList(HttpServletRequest request
						, HttpServletResponse response
						, @RequestParam Map<String, Object> param
						, Model model) {
		
		// 태스크 아이디, 멤버 아이디, 멤버 이름, 작업 가능 시간, 할당된 시간
		String tskId = "tsk-123456789";
		
		List<Map<String, Object>> list = new ArrayList();
		Map<String, Object> map1 = new HashMap();
		map1.put("tskId", tskId);
		map1.put("usrId", "his8457@naver.com");
		map1.put("usrNm", "황인선");
		map1.put("avlTm", "870");
		map1.put("assTm", "5");
		
		Map<String, Object> map2 = new HashMap();
		map2.put("tskId", tskId);
		map2.put("usrId", "qqq");
		map2.put("usrNm", "홍길동");
		map2.put("avlTm", "1210");
		map2.put("assTm", "10");
		
		Map<String, Object> map3 = new HashMap();
		map3.put("tskId", tskId);
		map3.put("usrId", "gomdori@gmail.com");
		map3.put("usrNm", "곰도리");
		map3.put("avlTm", "630");
		map3.put("assTm", "15");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		model.addAttribute("memberList",list);
		model.addAttribute("totAvlTm", "35h 10m"); //가용한 전체 시간
		model.addAttribute("estTm", "50:30"); //예상 작업 시간
		
		
		//List<Map<String, Object>> members = memberService.getMembers();
		
		return "/member/memberList";
	}
	
	@RequestMapping("/member/insertMembersTm")
	public void insertMembersTm(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam Map<String, Object> param
			, Model model
			, @RequestParam("assTm") String[] list) {
		
		System.out.println("test");
		
	}
	
	
	
	
}
