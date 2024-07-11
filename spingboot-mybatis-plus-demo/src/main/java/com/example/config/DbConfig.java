package com.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.AllArgsConstructor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author telzhou
 * @date 2024/7/11
 */

@Configuration
@AutoConfigureBefore(MybatisPlusAutoConfiguration.class)
@MapperScan(basePackages = "com.example.mapper.user", sqlSessionFactoryRef = "userSqlSessionFactory")
@MapperScan(basePackages = "com.example.mapper.post", sqlSessionFactoryRef = "postSqlSessionFactory")
@AllArgsConstructor
@EnableConfigurationProperties({MybatisPlusProperties.class})
public class DbConfig {

    private final MybatisPlusProperties properties;
    private final ResourceLoader resourceLoader;
    private final Interceptor[] interceptors;
    private final List<ConfigurationCustomizer> configurationCustomizers;

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
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);

        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        applyConfiguration(factory);


        if (this.properties.getConfigurationProperties() != null) {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        if (!ObjectUtils.isEmpty(this.interceptors)) {
            factory.setPlugins(this.interceptors);
        }
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (this.properties.getTypeAliasesSuperType() != null) {
            factory.setTypeAliasesSuperType(this.properties.getTypeAliasesSuperType());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }
        GlobalConfig globalConfig = this.properties.getGlobalConfig();
        factory.setGlobalConfig(globalConfig);
        return factory.getObject();
    }

    @Bean
    public SqlSessionFactory postSqlSessionFactory(@Qualifier("postDataSource") DataSource dataSource) throws Exception {

        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        applyConfiguration(factory);
        if (this.properties.getConfigurationProperties() != null) {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        if (!ObjectUtils.isEmpty(this.interceptors)) {
            factory.setPlugins(this.interceptors);
        }
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (this.properties.getTypeAliasesSuperType() != null) {
            factory.setTypeAliasesSuperType(this.properties.getTypeAliasesSuperType());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }
        GlobalConfig globalConfig = this.properties.getGlobalConfig();
        factory.setGlobalConfig(globalConfig);
        return factory.getObject();
    }

    private void applyConfiguration(MybatisSqlSessionFactoryBean factory) {
        MybatisPlusProperties.CoreConfiguration coreConfiguration = this.properties.getConfiguration();
        MybatisConfiguration configuration = null;
        if (coreConfiguration != null || !StringUtils.hasText(this.properties.getConfigLocation())) {
            configuration = new MybatisConfiguration();
        }
        if (configuration != null && coreConfiguration != null) {
            coreConfiguration.applyTo(configuration);
        }
        if (configuration != null && !CollectionUtils.isEmpty(this.configurationCustomizers)) {
            for (ConfigurationCustomizer customizer : this.configurationCustomizers) {
                customizer.customize(configuration);
            }
        }
        factory.setConfiguration(configuration);
    }

}
