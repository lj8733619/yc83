package com.yc.CS3Pljblog.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.CS3Pljblog.bean.Category;

public interface CategoryMapper {
	
	@Select("select * from Category where id=#{id}")
	public Category selectById(int id);

}
