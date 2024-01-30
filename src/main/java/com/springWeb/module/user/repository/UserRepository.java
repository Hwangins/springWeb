package com.springWeb.module.user.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository {

	/** [회원가입] 생성된 인증번호 저장(확인용) */
	public void insertAuthCode(Map<String, Object> param);
	
}
