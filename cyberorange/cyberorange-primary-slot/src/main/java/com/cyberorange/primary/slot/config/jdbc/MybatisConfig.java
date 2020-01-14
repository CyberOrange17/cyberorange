package com.cyberorange.primary.slot.config.jdbc;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.cyberorange.primary.slot.config.interceptor.MybatisSqlInterceptor;

@Configuration
@MapperScan(basePackages = { "com.cyberorange.primary.mapper" })
public class MybatisConfig {

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		MybatisSqlInterceptor mybatisSqlInterceptor = new MybatisSqlInterceptor();
		sessionFactory.setPlugins(new Interceptor[] { mybatisSqlInterceptor });
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath*:/mapper/**/*.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public MybatisSqlInterceptor mybatisSqlInterceptor() {
		return new MybatisSqlInterceptor();
	}
}
