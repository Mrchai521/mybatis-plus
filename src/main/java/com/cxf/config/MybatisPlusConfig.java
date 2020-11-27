package com.cxf.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xfchai
 * @ClassName MybatisPlusConfig.java
 * @Description MybaticePlus配置分页文件
 * @createTime 2020/11/27 09:39:00
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * Mybatis-plus分页插件
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }
}
