package com.yc.CZS3Pljspringboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.yc.CZS3Pljspringboot.biz.MailBiz;

@SpringBootTest
class CzS3PljSpringbootApplicationTests {
	
	@Resource
	private JdbcTemplate jt;

	@Test
	void contextLoads() {
		Assert.notNull(jt, "jt不能为空");
		   jt.update("insert into account values(null,?,?,?)",5000,"小二","123");
		   jt.update("insert into account values(null,?,?,?)",5000,"李四","123");
		   jt.update("insert into account values(null,?,?,?)",5000,"王五","123");
		   jt.update("insert into account values(null,?,?,?)",5000,"小刘","123");
	}
	@Resource
	private MailBiz mbiz;
	@Test
	void test1() {
		mbiz.sendSimpleMail("2098292371@qq.com", "测试", "我发的邮件");
	}

}
