package com.example.chartjs.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chartjs.mapper.PlayerMapper;

@RestController
public class PlayerRest {
	@Autowired PlayerMapper playerMapper;
	
	@PostMapping("/rest/avgAgeByCountry")
	public List<Map<String, Object>> avgAgeByCountry(){
		return playerMapper.selectAvgAgeByCountry();
	}
	@PostMapping("/rest/countBygender")
	public List<Map<String, Object>> countBygender(){
		return playerMapper.selectCountBygender();
	}
	@PostMapping("/rest/countByYearAndCountry")
	public List<Map<String, Object>> countByYearAndCountry(){
		return playerMapper.selectCountByYearAndCountry();
	}
	@PostMapping("/rest/totalCountByYear")
	public List<Map<String, Object>> totalCountByYear(){
		return playerMapper.selectTotalCountByYear();
	}
}
