package com.example.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author zhou1
 * @since 2021/6/30
 */
@Configuration
@MapperScan(basePackages = "com.example.mapper.order", sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderConfig {

    @Primary
    @Bean(name = "orderDataSource")
    public DataSource orderDataSource(DbProperties dbProperties) {
        return DataSourceBuilder.create(dbProperties.getOrder(), "orderResourceName");
    }

    @Primary
    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource) throws Exception {
        // final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/mapper/order/*.xml"));
        return sessionFactory.getObject();
    }
}
