package com.springWeb.module.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {
	
	/** Sample 단건 조회 */
	public Map<String, Object> selectDev(Map<String, Object> param);
	
	/** Sample 다건 조회*/
	public List<Map<String, Object>> selectDevList(Map<String, Object> param);
	
	/** Sample 단건 저장 */
	public int insertDev(Map<String, Object> param);

}
