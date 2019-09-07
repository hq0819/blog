package com.hq.service;

import java.util.List;

import com.hq.pojo.Catalog;

public interface CatalogService {
	
	List<Catalog> selByType(int type);

}
