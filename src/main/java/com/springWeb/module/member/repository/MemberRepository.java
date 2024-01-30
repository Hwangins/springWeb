package com.springWeb.module.member.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("memberRepository")
public interface MemberRepository {
	
	public List<Map<String, Object>> getMembers();
}
	