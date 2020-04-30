package org.hanrw.spring.jpa;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hanrw
 * @date 2020/4/30 3:54 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApp.class)
public class ContextTests {
  @Resource DataSource dataSource;

  @Test
  public void contextLoads() throws SQLException {
    System.out.println("数据源-->" + dataSource.getClass());
    Connection connection = dataSource.getConnection();

    System.out.println("连接-->" + connection);
    System.out.println("连接地址-->" + connection.getMetaData().getURL());
    connection.close();
  }
}
