package com.yc.CS3Pljblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.CS3Pljblog.bean.Comment;
import com.yc.CS3Pljblog.dao.CommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private CommentMapper cMapper;
	public Comment create(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}

}