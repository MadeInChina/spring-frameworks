package org.hanrw.spring.beans.config;

import org.hanrw.spring.beans.annotation.EnableMethodCostTime;
import org.hanrw.spring.beans.annotation.EnableQuery;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanrw
 * @date 2020/3/21 11:51 AM
 */
@Configuration
@ComponentScan
@EnableMethodCostTime
@EnableQuery
public class MainConfig {}
