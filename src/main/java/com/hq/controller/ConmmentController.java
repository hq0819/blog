package com.hq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hq.pojo.Comment;
import com.hq.service.CommentService;

@Controller
public class ConmmentController {
	@Autowired
	CommentService commentServiceImpl;
	
	
	@RequestMapping("admin/article/comment")
	public String commentList(long id,HttpSession session) {
		List<Comment> list = commentServiceImpl.SelByArcId(id);
		
		session.setAttribute("comments", list);
		
		return "comment_list";
		
		
	}
	@ResponseBody
	@RequestMapping("/api/comment/del")
	public int deleteComment(long id) {
		return commentServiceImpl.deById(id);
		
	}
	
	
	


}
