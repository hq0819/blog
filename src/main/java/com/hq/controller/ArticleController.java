package com.hq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hq.pojo.Admin;
import com.hq.pojo.Article;
import com.hq.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleServiceImpl;
	
	@RequestMapping("admin/article/add")
	public String addArticle() {
		
		return "article_add";
	}
	
	@ResponseBody
	@RequestMapping("admin/article/add/do")
	public void addExcu(Article article,HttpSession session) {
		Admin admin = (Admin)session.getAttribute("admin");
		article.setPid(admin.getId());
		
		 articleServiceImpl.insArticle(article);
		
	}
	
	
	
	
	/**
	 * 文章列表
	 * @param req
	 * @return
	 */
	@RequestMapping("admin/article/list")
	public String ArticleList(HttpServletRequest req) {
		articleServiceImpl.selArticleByUid(req);
		
		return "article_list";
	}
	
	/**
	 * 文章详情
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("admin/article/detail")
	public String ArticleList(int id,HttpSession session) {
		Article article = articleServiceImpl.selByid(id);
		session.setAttribute("article", article);
		
		return "article_detail";
	}
	/**
	 * 文章修改
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin/article/edit")
	public String Articleedit(int id,HttpSession session) {
		Article article1 = articleServiceImpl.updeteByid(id);
		
		
		session.setAttribute("article", article1);
		return "article_edit";
	}
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	@RequestMapping("api/article/del")
	@ResponseBody
	public int ArticleDelete(int id) {
		return articleServiceImpl.delById(id);
	
	}


}
