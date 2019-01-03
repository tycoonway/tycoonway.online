package com.gltv.bigwig.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gltv.bigwig.domain.BigWigRank;
import com.gltv.bigwig.service.BigWigSdkService;
import com.gltv.bigwig.utils.ResultSetUtil;


/**
 * 用户信息
 * 
 * @author 
 *
 */
@RestController
@RequestMapping(path = "/bigWigSdk")
public class BigWigController  {//extends BaseController
	private static final Logger logger = LoggerFactory.getLogger(BigWigController.class);
	
	@Autowired
	BigWigSdkService bigWigSdkService;

	@RequestMapping(value = "/setBigRankAddr", method = RequestMethod.POST)
	public ResultSetUtil setBigRankAddr(@RequestParam(value = "address", required = true) String address) {
		
		Hashtable<String, Object> ht = new Hashtable<String, Object>();
		
		BigWigRank bigWigRank = bigWigSdkService.findByAddress(address);
		
		
		//logger.info(bigWigRank.toString());
		if(bigWigRank==null||bigWigRank.getLevel()==null||bigWigRank.getLevel()<0) {
			bigWigRank = new BigWigRank(address,"",0L);
			bigWigSdkService.save(bigWigRank);
		}
		ht.put("flag", true);
		return ResultSetUtil.resultSet(200l, "success", ht);
	}


	@RequestMapping(value = "/RankList", method = RequestMethod.POST)
	public ResultSetUtil RankList(@RequestParam(value = "page", required = true) int page,@RequestParam(value = "size", required = true) int size) {
		Hashtable<String, Object> ht = new Hashtable<String, Object>();
		
		Sort sort = new Sort(Direction.DESC, "level");
    	Pageable pageable = new PageRequest(page, size, sort);
    	
		Page<BigWigRank> lm = bigWigSdkService.findAll(pageable);
		
		ht.put("RankList", lm);

		return ResultSetUtil.resultSet(200l, "success", ht);
	}
}
