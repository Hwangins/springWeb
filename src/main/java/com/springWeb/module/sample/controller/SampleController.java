package com.springWeb.module.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springWeb.module.sample.service.SampleService;


/**
 * @author 황인선
 * @version 1.0.0
 * @since 2024.01.01
 * 
 * @title Sample Controller
 * @content 
 * 1.페이지 이동
 * 2.데이터 조회 (동기)
 * 3.데이터 조회 (비동기)
 * 4.데이터 저장 (동기)
 * 5.데이터 저장 (비동기)
 * 6.데이터 수정 (동기)
 * 7.데이터 수정 (비동기)
 * 8.데이터 삭제 (동기)
 * 9.데이터 삭제 (비동기)
 * */

@Controller
@PropertySource("classpath:property/message/message.properties")
public class SampleController {

	@Resource(name = "sampleService")
	private SampleService sampleService;
	
	@Resource(name = "messageSource")
	private MessageSource messageSource;
	
	@Value("${fail.save.msg}")
	private String failMsg;
	
	/**
	 * 메서드명 작성 예시
	 * 1.페이지 이동 
	 *  - 메서드명 : go{페이지명}
	 *  - 반환형 : String {페이지명}
	 *  - {페이지명} : jsp명
	 * 
	 * 2.데이터 조회(단건)
	 *  - 메서드명 : select{명사}
	 *  - 반환형 : Map<String, Object> 
	 * 2.데이터 조회(다건)
	 *  - 메서드명 : select{명사}List
	 *  - 반환형 : List<Map<String, Object>>
	 *  
	 * 3.데이터 저장 (단건)
	 *  - 메서드명 : inesrt{명사}
	 *  - 반환형 : void
	 * 3.데이터 저장(다건)
	 *  - 메서드명 : inesrt{명사}List
	 *  - 반환형 : void
	 * 
	 * 4.데이터 수정(단건)
	 *  - 메서드명 : update{명사}
	 *  - 반환형 : void
	 * 4.데이터 수정(다건)
	 *  - 메서드명 : update{명사}List
	 *  - 반환형 : void

	 * 5.데이터 삭제(단건)
	 *  - 메서드명 : delete{명사}
	 *  - 반환형 : void
	 * 5.데이터 삭제(다건)
	 *  - 메서드명 : delete{명사}List
	 *  - 반환형 : void
	 * 
	 * */
	
	/**
	 * @Title : 페이지 이동 Sample
	 * @return 전환될 페이지의 jsp명
	 * */
	@RequestMapping("/sample/main")
	public String goSampleMain(Model model, 
			                   @RequestParam Map<String, Object> param){
		/* 1.데이터 조회 */
		//1.1 단건 : select{명사}
		Map<String, Object> devInfo = sampleService.selectDev(param);
		//1.2 다건 : select{명사}List
		List<Map<String, Object>> devList = sampleService.selectDevList(param);
		
		/* view로 보낼때 */
		model.addAttribute("devInfo", devInfo);
		model.addAttribute("devList", devList);
		
		/* message 프로퍼티 읽기 */
		String msg = messageSource.getMessage("confirm.save.msg", null, LocaleContextHolder.getLocale());
		
		System.out.println(failMsg);
		
		/* jsp path */
		return "sample/sample-main";
	}
	
	/**
	 * @Title : (비동기) 데이터 리스트 조회 Sample
	 * @return 데이터 리스트 반환
	 * */
	@RequestMapping("/sample/list")
	@ResponseBody
	public List<Map<String, Object>> getDevList(HttpServletRequest request,
												HttpServletResponse response,
												@RequestParam Map<String, Object> param){
		
		List<Map<String, Object>> list = sampleService.selectDevList(param);
		
		return list;
		
	}
	
	/**
	 * Sample 데이터 저장
	 * */
	@RequestMapping("/sample/save")
	public Map<String, Object> save(HttpServletRequest request,
									HttpServletResponse response,
									@RequestParam Map<String, Object> param) {
		
		Map<String, Object> responseParam = new HashMap<>();
		
		String[] funcNms = request.getParameterValues("funcNm");
		String[] urls = request.getParameterValues("url");
		String[] compYns = request.getParameterValues("compYn");
		
		int saveCnt = 0;

		for(int i = 0; i < funcNms.length; i++){
			param = new HashMap<>();
			param.put("funcNm", funcNms[i]);
			param.put("url", urls[i]);
			param.put("compYn", compYns[i]);
			
			saveCnt += sampleService.insertDev(param);
		}
		
		String msg = "성공적으로 " + saveCnt + "개의 데이터가 저장되었습니다.";
		
		responseParam.put("resultMsg", msg);
		
		return responseParam;
	}
	
	
}
