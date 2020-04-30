package org.hanrw.spring.jpa.service;

import static org.junit.Assert.assertEquals;

import org.hanrw.spring.jpa.JpaApp;
import org.hanrw.spring.jpa.entity.AccountInfo;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hanrw
 * @date 2020/4/30 4:04 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApp.class)
public class AccountServiceServiceITest {
  @Autowired AccountService accountService;
  private AccountInfo accountInfo;


  @Test
  public void should_save_account_success(){
    accountInfo = new AccountInfo();
    accountInfo.setAccountId(1);
    accountInfo.setBalance(10000);
    accountService.create(accountInfo);
    accountInfo = accountService.findByAccountId(1);
    assertEquals(10000,accountInfo.getBalance(),0.1);
  }

}
