package com.hq.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.ListUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hq.pojo.Catalog;
import com.hq.service.CatalogService;

@Controller
public class CatalogController {
	@Autowired
	CatalogService CatalogServiceImpl;
	
	@RequestMapping("catalog")
	@ResponseBody
	public String catalog(int type,HttpSession session) {
		List<Catalog> list = CatalogServiceImpl.selByType(type);
		session.setAttribute("catalog", list);
		System.out.println(list);
		return "200";
	}

}
