package org.hanrw.spring.jpa.service;

import org.hanrw.spring.jpa.JpaApp;
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
public class PayServiceServiceITest {
  @Autowired PayService payService;



}
