package com.yc.CS3Pljblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.CS3Pljblog.bean.Comment;

public interface CommentMapper {

	@Insert("insert into comment values (null,"
			+ "#{articleid},#{content},#{createby},now())")
	public int insert(Comment comm);
	
	@Select("select * from comment where articleid=#{articleid}")
	public List<Comment> selectByAricle(int articleid);
	
}
