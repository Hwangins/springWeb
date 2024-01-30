package com.springWeb.module.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface MemberService {
	
	public List<Map<String, Object>> getMembers(); 
}
