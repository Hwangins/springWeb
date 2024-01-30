package com.springWeb.util;

import java.util.Random;

/**
 * <p>Title : 인증 관련 유틸</p>
 * <p>Desc. : 인증과 관련된 유틸</p>
 * 
 * @version 1.0.0
 * @author 황인선
 * @since 2023-12-28
 * 
 * */
public class AuthenticationUtil {
	
	/**
	 * <p>Desc. : 회원가입 인증번호 생성</p>
	 * @return 0 ~ 9로 구성된 난수 N자리 숫자를 문자열로 반환
	 * @param 인증번호 자릿수
	 * */
	public static String generateAuthCode(int cnt){
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		
		for(int i = 0; i < cnt; i++){
			sb.append(random.nextInt(10));
		}
		
		return sb.toString();
	} 
}
