package org.hanrw.spring.transaction;

import org.hanrw.spring.transaction.config.TransactionConfig;
import org.hanrw.spring.transaction.service.PayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionApp {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(TransactionConfig.class);
    PayService payService = context.getBean(PayService.class);
    payService.pay("1", 5);
  }
}
