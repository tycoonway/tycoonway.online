package com.gltv.bigwig.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.gltv.bigwig.domain.BigWigRank;


public interface BigWigRankRepository extends Repository<BigWigRank, Long>
{
	Page<BigWigRank> findAll(Pageable pageable);
	
	BigWigRank findByAddress(String address);
	
}