package com.beauty.basic.configurations.spring.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Throwables;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MyBatis 配置管理对象
 */
@Configuration
@MapperScan(basePackages = "com.beauty.basic.datasource.persistent.mybatis.mappers")
public class MybatisConfiguration {
    @Value("${mybatis.datasource.url}")
    private String urlFormat;
    @Value("${mybatis.datasource.driver-class-name}")
    private String driver;
    @Value("${mybatis.datasource.username}")
    private String username;
    @Value("${mybatis.datasource.password}")
    private String password;
    @Value("${mysqlUrl}")
    private String mysqlUrl;

    /**
     * Mybatis SqlSessionFactory
     *
     * @param dataSource datasource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
            return sessionFactory.getObject();
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    @Bean
    public DataSource buildDruidDataSource() {

        DruidDataSource datasource = new DruidDataSource();
        String url = String.format(urlFormat, mysqlUrl);

        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driver);

        //configuration
        //初始化大小，最小，最大
        datasource.setInitialSize(50);
        datasource.setMinIdle(20);
        datasource.setMaxActive(70);
        //配置获取连接等待超时的时间
        datasource.setMaxWait(60000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        datasource.setMinEvictableIdleTimeMillis(300000);
        datasource.setValidationQuery("SELECT 1 FROM DUAL");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);
        //打开PSCache，并且指定每个连接上PSCache的大小
        datasource.setPoolPreparedStatements(true);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(20);
        datasource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000  ");
        return datasource;
    }

}
