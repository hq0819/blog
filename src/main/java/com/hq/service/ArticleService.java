package com.hq.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import com.hq.pojo.Article;
import com.hq.pojo.Comment;

public interface ArticleService {
	
	List<Article> selArticleByUid(HttpServletRequest req);
	
	Article  selByid(int id);
	
	Article updeteByid(int id);
	
	int delById(int id);
	
	int insArticle(Article article);
	
	
	

}
