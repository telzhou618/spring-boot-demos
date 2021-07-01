package com.example.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;

import javax.sql.DataSource;

/**
 * @author zhou1
 * @since 2021/7/1
 */
public class DataSourceBuilder {

    public static DataSource create(DbProperties.DbProp dbProp, String uniqueResourceName) {

        DruidXADataSource dataSource = new DruidXADataSource();
        dataSource.setUrl(dbProp.getUrl());
        dataSource.setPassword(dbProp.getPassword());
        dataSource.setUsername(dbProp.getUsername());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(dataSource);
        atomikosDataSourceBean.setUniqueResourceName(uniqueResourceName);
        return atomikosDataSourceBean;
    }
}
