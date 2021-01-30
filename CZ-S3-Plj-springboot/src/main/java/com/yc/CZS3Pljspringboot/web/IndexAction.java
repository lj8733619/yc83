package com.yc.CZS3Pljspringboot.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.CZS3Pljspringboot.dao.Account;
import com.yc.CZS3Pljspringboot.dao.AccountDao;

@RestController//控制器组件注解
public class IndexAction {
	//SpringMVC注解 控制方法 相当于web项目的doGet和doPost方法
	@RequestMapping("hello.action")
    public String hello() {
    	return "hello world";
    }
	private AccountDao adao;
	public List<Account> query(){
		return null;
		
	}
}
