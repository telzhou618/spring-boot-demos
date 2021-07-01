package com.example.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author zhou1
 * @since 2021/6/30
 */
@Configuration
@MapperScan(basePackages = "com.example.mapper.shop", sqlSessionFactoryRef = "shopSqlSessionFactory")
public class ShopConfig {

    @Bean(name = "shopDataSource")
    public DataSource shopDataSource(DbProperties dbProperties) {
        return DataSourceBuilder.create(dbProperties.getShop(), "shopResourceName");
    }

    @Bean(name = "shopSqlSessionFactory")
    public SqlSessionFactory shopSqlSessionFactory(@Qualifier("shopDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/mapper/shop/*.xml"));
        return sessionFactory.getObject();
    }
}
