package com.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author telzhou
 * @date 2024/7/11
 */

@Configuration
@MapperScan(basePackages = "com.example.mapper.user", sqlSessionFactoryRef = "userSqlSessionFactory")
@MapperScan(basePackages = "com.example.mapper.post", sqlSessionFactoryRef = "postSqlSessionFactory")
public class DbConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.user")
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.post")
    public DataSource postDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/mapper/user/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionFactory postSqlSessionFactory(@Qualifier("postDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/mapper/post/*.xml"));
        return sessionFactory.getObject();
    }
}
