package com.hq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hq.mapper.CommentMapper;
import com.hq.pojo.Comment;
import com.hq.pojo.CommentExample;
import com.hq.pojo.CommentExample.Criteria;
import com.hq.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentMapper commentMapper;

	public List<Comment> SelByArcId(long id) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andArticleIdEqualTo(id);
		
		List<Comment> list = commentMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	public int deById(long id) {
		int index = commentMapper.deleteByPrimaryKey(id);
		return index;
		
		
	}

}
