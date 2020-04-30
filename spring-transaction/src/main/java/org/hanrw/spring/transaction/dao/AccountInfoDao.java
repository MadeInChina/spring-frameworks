package org.hanrw.spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountInfoDao {

  @Autowired private JdbcTemplate jdbcTemplate;

  public int updateAccountBalance(String accountId, double balance) {
    String sql = "update account_info set balance=balance-? where account_id=?";
    return jdbcTemplate.update(sql, balance, accountId);
  }

  public int saveAccountInfo(String accountId, double balance) {
    String sql = "insert into account_info(account_id,balance) values(?,?)";
    return jdbcTemplate.update(sql, accountId, balance);
  }

  public double qryBalanceByUserId(String accountId) {
    String sql = "select balance from account_info where account_id=" + accountId;
    return jdbcTemplate.queryForObject(sql, Double.class);
  }
}
