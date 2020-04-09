package org.hanrw.spring.service;

import org.hanrw.spring.beans.annotation.Query;
import org.springframework.stereotype.Component;

/**
 * @author hanrw
 * @date 2020/4/2 10:32 AM
 */
@Component
public interface QueryService {
  @Query(value = "select * from table")
  String query(String table);
}
