package com.yc.CZS3Pljspringboot.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AccountDao extends BaseDao{
	  @Resource
      private JdbcTemplate jt;
      public void insert(Account e) {
    	  jt.update("insert into account values(null,?,?,?)",e.getBalance(),e.getName(),e.getPwd());
    	  
      }
      public void update(Account e) {
    	  String sql="update account set balance=balance+? where accountid=?";
    	  jt.update(sql,e.getBalance(),e.getAccountid());
      }
      @SuppressWarnings("deprecation")
	public Account selectById(int id) {
      String sql="select * from account where accountid=?";
      Object[] params= {id};
      return jt.query(sql,params, rs->{
    	  rs.next();
    	  Account a=new Account();
    	  a.setAccountid(rs.getInt("accountid"));
    	  a.setName(rs.getString("name"));
    	  a.setBalance(rs.getDouble("balance"));
    	  a.setPwd(rs.getString("pwd"));
    	  return a;
      });
	 
      
      }
}
