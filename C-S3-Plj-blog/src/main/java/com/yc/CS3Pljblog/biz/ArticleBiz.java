package com.yc.CS3Pljblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.CS3Pljblog.bean.Article;
import com.yc.CS3Pljblog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Resource
	private ArticleMapper aMapper;
	
	public int create(Article art) {
		return aMapper.insert(art);
	}

}
