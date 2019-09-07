package com.hq.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.hq.mapper.ArticleMapper;
import com.hq.pojo.Admin;
import com.hq.pojo.Article;
import com.hq.pojo.ArticleExample;
import com.hq.pojo.ArticleExample.Criteria;
import com.hq.pojo.Comment;
import com.hq.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	ArticleMapper articleMapper;
	public List<Article> selArticleByUid(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		System.out.println(admin);
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(admin.getId());
		
		 List<Article> list = articleMapper.selectByExample(example);
		 session.setAttribute("articles", list);
		 return list;
	}
	public Article selByid(int id) {
		return articleMapper.selectByPrimaryKey(id);
		
		
	}
	
	/**
	 * 删除
	 */
	public Article updeteByid(int id) {
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		
		
		// TODO Auto-generated method stub
		return articleMapper.selectByExampleWithBLOBs(example).get(0);
	}
	public int delById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.deleteByPrimaryKey(id);
	}
	public int insArticle(Article article) {
		Date date = new Date();
		article.setClick(0);
		article.setTime(date);
		article.setPic("");
		
		
		// TODO Auto-generated method stub
		
		int index = articleMapper.insert(article);
		return index;
	}
	

}
