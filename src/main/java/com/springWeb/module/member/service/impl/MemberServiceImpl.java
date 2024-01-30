package com.springWeb.module.member.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springWeb.module.member.repository.MemberRepository;
import com.springWeb.module.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberRepository")
	private MemberRepository memberRepository;
	
	@Override
	public List<Map<String, Object>> getMembers() {
		return memberRepository.getMembers();
	}

}
