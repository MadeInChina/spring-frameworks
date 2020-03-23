package org.hanrw.spring.boot.autoconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author hanrw
 * @date 2020/3/23 1:39 PM
 */
@Configuration
@Import(MyImportSelector.class)
public class EnableMyAutoConfiguration {}
