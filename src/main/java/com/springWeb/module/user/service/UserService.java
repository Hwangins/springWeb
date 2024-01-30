package com.springWeb.module.user.service;

import java.util.Map;

public interface UserService {
	
	/** 회원가입 */
	public void join();
	
	/** 로그인 */
	public void login();
	
	/** 로그아웃 */
	public void logout();
	
	/** [회원가입] 생성된 인증번호 저장(확인용) */
	public void insertAuthCode(Map<String, Object> param) throws Exception;
	
	
}
