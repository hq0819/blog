package com.hq.service;

import java.util.List;

import com.hq.pojo.Comment;

public interface CommentService {
	
	List<Comment> SelByArcId(long id);
	
	int deById(long id);

}
