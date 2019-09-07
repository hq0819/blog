package com.hq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hq.mapper.CatalogMapper;
import com.hq.pojo.Catalog;
import com.hq.pojo.CatalogExample;
import com.hq.pojo.CatalogExample.Criteria;
import com.hq.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService{
	@Autowired
	CatalogMapper catalogMapper;

	public List<Catalog> selByType(int type) {
		
		CatalogExample example = new CatalogExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type==1?true:false);
		return catalogMapper.selectByExample(example);
	}
	

}
