package com.gltv.bigwig.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gltv.bigwig.service.BigWigSdkService;
import com.gltv.bigwig.domain.BigWigRank;
import com.gltv.bigwig.repository.BigWigRankJpaRepository;
import com.gltv.bigwig.repository.BigWigRankRepository;

@Service
public class BigWigSdkServiceImpl implements BigWigSdkService {
	
	private static final Logger logger = LoggerFactory.getLogger(BigWigSdkServiceImpl.class);
	
	@Autowired
	private  BigWigRankJpaRepository bigWigRankJpaRepository;
	
	@Autowired
    private BigWigRankRepository bigWigRankRepository;
	

	@Override
	public BigWigRank findByAddress(String address) {
		return bigWigRankRepository.findByAddress(address);
	}
	
	@Override
	public BigWigRank save(BigWigRank bigWigRank){
		return bigWigRankJpaRepository.save(bigWigRank);
	}
	
	@Override
	public Page<BigWigRank> findAll(Pageable pageable){
		return bigWigRankRepository.findAll(pageable);
	}
	
}
