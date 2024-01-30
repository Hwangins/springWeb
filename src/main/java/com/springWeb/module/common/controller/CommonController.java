package com.springWeb.module.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index"; // 또는 해당하는 뷰 이름 또는 경로
    }
	
	@RequestMapping(value="/common/test", produces = "application/json")
	@ResponseBody
	public Map<String, Object> test(HttpServletRequest request, 
									HttpServletResponse response,
									@RequestParam Map<String, Object> param
			         				) 
	{
		System.out.println("test");
		Map<String, Object> result = new HashMap();
		result.put("id", "myId");
		result.put("name", "ishwang");
		
		return result;
	}
}
