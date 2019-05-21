package com.bidewu.web.annotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by zengqingzhou on 2019/5/11.
 */
@Configuration
public class DruidConfig {

    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Value("${bidewu.database.driverClass}")
    private String driverClass;

    @Value("${bidewu.database.url}")
    private String pgUrl;

    @Value("${bidewu.database.user}")
    private String user;

    @Value("${bidewu.database.password}")
    private String password;

    @Value("${bidewu.database.dbIinitialSize}")
    private int initialSize;

    @Value("${bidewu.database.dbMinIdle}")
    private int minIdle;

    @Value("${bidewu.database.dbMaxActive}")
    private int maxActive;

    @Value("${bidewu.database.maxWait}")
    private int maxWait;

    @Value("${bidewu.database.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${bidewu.database.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${bidewu.database.validationQuery}")
    private String validationQuery;

    @Value("${bidewu.database.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${bidewu.database.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${bidewu.database.testOnReturn}")
    private boolean testOnReturn;

    @Value("${bidewu.database.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${bidewu.database.filters}")
    private String filters;

    @Bean(name = "datasourceWeb")
    @Primary
    public DataSource druidDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(pgUrl);
        datasource.setUsername(user);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClass);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        return datasource;
    }
}
