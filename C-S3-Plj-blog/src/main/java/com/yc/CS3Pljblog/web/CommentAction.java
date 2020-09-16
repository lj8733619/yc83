package com.yc.CS3Pljblog.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.CS3Pljblog.bean.Comment;
import com.yc.CS3Pljblog.bean.Result;
import com.yc.CS3Pljblog.bean.User;
import com.yc.CS3Pljblog.biz.CommentBiz;
import com.yc.CS3Pljblog.dao.CommentMapper;

@RestController
public class CommentAction {
	
	@Resource
	private CommentMapper cMapper;

	@Resource
	private CommentBiz cBiz;

	@PostMapping("comment")
	public Result comment(Comment comm, @SessionAttribute User loginedUser) {
		comm.setCreateby(loginedUser.getId());
		cBiz.create(comm);
		return new Result(1, "回复成功", comm);
	}
	
	
	@GetMapping("queryComm")
	public Result comment(int articleid) {
		return new Result(1, "查询回复成功", cMapper.selectByAricle(articleid));
	}
	
}
