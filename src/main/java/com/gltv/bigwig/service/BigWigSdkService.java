package com.gltv.bigwig.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gltv.bigwig.domain.BigWigRank;


public interface BigWigSdkService {
    
	BigWigRank findByAddress(String address);
	
	BigWigRank save(BigWigRank bigWigRank);
	
	Page<BigWigRank> findAll(Pageable pageable);

}
