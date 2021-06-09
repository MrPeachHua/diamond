package com.fd.diamond.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@Slf4j
@Configuration
@MapperScan(basePackages = {"com.fd.diamond.mappers.master"}, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourcesConfig {
    //主数据源mapper xml文件夹的路径
    private static final String MAPPER_LOCAL = "classpath*:mybatis/*.xml";

    @ConfigurationProperties("spring.datasource.druid.master")
    @Primary
    @Bean(name = "masterDataSource")
    public DataSource druidDataSource() {
        try {
            return DruidDataSourceBuilder.create()
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }
}