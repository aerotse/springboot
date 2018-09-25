package com.liuh.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Liuh
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfig {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private int initialSize;

    private int maxActive;

    private int minIdle;

    private int maxWait;

    private long timeBetweenEvictionRunsMillis;

    private long minEvictableIdleTimeMillis;

    private String validationQuery;

    private boolean testWhileIdle;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean poolPreparedStatements;

    private int maxPoolPreparedStatementPerConnectionSize;

    private String filters;

    public DruidConfig() {
    }

    public DruidConfig(String url, String username, String password,
                       String driverClassName, int initialSize,
                       int maxActive, int minIdle, int maxWait,
                       long timeBetweenEvictionRunsMillis,
                       long minEvictableIdleTimeMillis, String validationQuery,
                       boolean testWhileIdle, boolean testOnBorrow, boolean testOnReturn,
                       boolean poolPreparedStatements, int maxPoolPreparedStatementPerConnectionSize,
                       String filters) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
        this.initialSize = initialSize;
        this.maxActive = maxActive;
        this.minIdle = minIdle;
        this.maxWait = maxWait;
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
        this.validationQuery = validationQuery;
        this.testWhileIdle = testWhileIdle;
        this.testOnBorrow = testOnBorrow;
        this.testOnReturn = testOnReturn;
        this.poolPreparedStatements = poolPreparedStatements;
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
        this.filters = filters;
    }

    public DataSource mysqlDataSource() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(this.url);
        druidDataSource.setUsername(this.username);
        druidDataSource.setPassword(this.password);
        druidDataSource.setDriverClassName(this.driverClassName);
        druidDataSource.setInitialSize(this.initialSize);
        druidDataSource.setMaxActive(this.maxActive);
        druidDataSource.setMinIdle(this.minIdle);
        druidDataSource.setMaxWait(this.maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(this.validationQuery);
        druidDataSource.setTestWhileIdle(this.testWhileIdle);
        druidDataSource.setTestOnBorrow(this.testOnBorrow);
        druidDataSource.setTestOnReturn(this.testOnReturn);
        druidDataSource.setPoolPreparedStatements(this.poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setFilters(this.filters);

        try {
            if (null != druidDataSource) {
                druidDataSource.setFilters("wall,stat");
                druidDataSource.setUseGlobalDataSourceStat(true);
                druidDataSource.init();
            }
        } catch (Exception e) {
            throw new RuntimeException("load datasource error, dbProperties is :", e);
        }


        return druidDataSource;
    }

}