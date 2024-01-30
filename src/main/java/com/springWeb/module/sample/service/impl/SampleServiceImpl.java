package com.springWeb.module.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springWeb.module.sample.repository.SampleRepository;
import com.springWeb.module.sample.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl implements SampleService{

	@Resource(name = "sampleRepository")
	private SampleRepository sampleRepository;
	
	@Override
	public Map<String, Object> selectDev(Map<String, Object> param) {
		return sampleRepository.selectDev(param);
	}
	
	@Override
	public List<Map<String, Object>> selectDevList(Map<String, Object> param) {
		return sampleRepository.selectDevList(param);
	}

	@Override
	public int insertDev(Map<String, Object> param) {
		return sampleRepository.insertDev(param);
	}

}
