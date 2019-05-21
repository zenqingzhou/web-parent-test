package com.bidewu.web.annotation.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by zengqingzhou on 2019/5/11.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.bidewu.web.dao", sqlSessionFactoryRef="sqlSessionFactoryWeb")
public class MyBatisConfig implements TransactionManagementConfigurer {

    @Autowired
    @Qualifier("datasourceWeb")
    @SuppressWarnings("SpringJavaAutowiringInspection")
    DataSource dataSource;

    @Bean(name = "sqlSessionFactoryWeb")
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean(){
        SqlSessionFactoryBean been = new SqlSessionFactoryBean();
        been.setDataSource(dataSource);
        been.setTypeAliasesPackage("com.bidewu.web.dao");
        been.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/mybatis.xml"));

        //添加xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            been.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
            return been.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryWeb") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Primary
    @Override
    public DataSourceTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
