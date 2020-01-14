package com.cyberorange.console.config.interceptor;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MyBatis SQL 日志拦截器
 * 
 * @author 黄传举
 */
@Intercepts(value = {
		@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
public class MybatisSqlInterceptor implements Interceptor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 拦截切入点
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 获取SQL语句
		String sql = getSqlByInvocation(invocation);
		if (StringUtils.isBlank(sql)) {
			return invocation.proceed();
		}
		// 将SQL特殊字符替换成空格
		String sql2Reset = replaceAllSpecialCharacters(sql);
		resetSqlToInvocation(invocation, sql2Reset);

		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = null;
		if (invocation.getArgs().length > 1) {
			parameter = invocation.getArgs()[1];
		}
		String sqlId = mappedStatement.getId();
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		Configuration configuration = mappedStatement.getConfiguration();
		Object returnValue = null;
		long start = System.currentTimeMillis();
		returnValue = invocation.proceed();
		long end = System.currentTimeMillis();
		long time = (end - start);
		String sqlString = getLogSql(configuration, boundSql, sqlId, time);
		log.info("[SQL执行情况]{}", sqlString);

		return returnValue;
	}

	/**
	 * 替换特殊字符为空格
	 * 
	 * @param sql
	 * @return
	 */
	public String replaceAllSpecialCharacters(String sql) {
		String newSql = null;
		if (sql != null) {
			Pattern p = Pattern.compile("\\s{2,}|\t|\r|\n");
			Matcher m = p.matcher(sql);
			newSql = m.replaceAll(" ");
		}
		return newSql;
	}

	/**
	 * 获取打印日志SQL
	 * 
	 * @param configuration
	 * @param boundSql
	 * @param sqlId
	 * @param time
	 * @return
	 */
	public static String getLogSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
		String sql = showSql(configuration, boundSql);
		StringBuilder str = new StringBuilder(100);
		str.append("耗时[").append(time).append("]毫秒,");
		str.append(sqlId);
		str.append(": ");
		str.append(sql);
		return str.toString();
	}

	/**
	 * 获取参数值
	 * 
	 * @param obj
	 * @return
	 */
	private static String getParameterValue(Object obj) {
		String value = null;
		if (obj instanceof String) {
			value = "'" + obj.toString() + "'";
		} else if (obj instanceof Date) {
			DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
			value = "'" + formatter.format(new Date()) + "'";
		} else {
			if (obj != null) {
				value = obj.toString();
			} else {
				value = "";
			}
		}
		return Matcher.quoteReplacement(value);
	}

	/**
	 * 获取显示替换参数后的SQL
	 * 
	 * @param configuration
	 * @param boundSql
	 * @return
	 */
	public static String showSql(Configuration configuration, BoundSql boundSql) {
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
		if (!parameterMappings.isEmpty() && parameterObject != null) {
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
				sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));
			} else {
				MetaObject metaObject = configuration.newMetaObject(parameterObject);
				for (ParameterMapping parameterMapping : parameterMappings) {
					String propertyName = parameterMapping.getProperty();
					if (metaObject.hasGetter(propertyName)) {
						Object obj = metaObject.getValue(propertyName);
						sql = sql.replaceFirst("\\?", getParameterValue(obj));
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						Object obj = boundSql.getAdditionalParameter(propertyName);
						sql = sql.replaceFirst("\\?", getParameterValue(obj));
					}
				}
			}
		}
		return sql;
	}

	@Override
	public Object plugin(Object obj) {
		return Plugin.wrap(obj, this);
	}

	@Override
	public void setProperties(Properties arg0) {
	}

	/**
	 * 获取SQL语句
	 *
	 * @param invocation
	 * @return
	 */
	private String getSqlByInvocation(Invocation invocation) {
		final Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameterObject = args[1];
		BoundSql boundSql = ms.getBoundSql(parameterObject);
		return boundSql.getSql();
	}

	/**
	 * 将SQL语句重置到invocation
	 * 
	 * @param invocation
	 * @param sql
	 */
	private void resetSqlToInvocation(Invocation invocation, String sql) {
		final Object[] args = invocation.getArgs();
		MappedStatement statement = (MappedStatement) args[0];
		Object parameterObject = args[1];
		BoundSql boundSql = statement.getBoundSql(parameterObject);
		MappedStatement newStatement = newMappedStatement(statement, new BoundSqlSqlSource(boundSql));
		MetaObject msObject = MetaObject.forObject(newStatement, new DefaultObjectFactory(),
				new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
		msObject.setValue("sqlSource.boundSql.sql", sql);
		args[0] = newStatement;
	}

	private MappedStatement newMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource,
				ms.getSqlCommandType());
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
			StringBuilder keyProperties = new StringBuilder();
			for (String keyProperty : ms.getKeyProperties()) {
				keyProperties.append(keyProperty).append(",");
			}
			keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
			builder.keyProperty(keyProperties.toString());
		}
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());

		return builder.build();
	}

	public String getOperateType(Invocation invocation) {
		final Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		SqlCommandType commondType = ms.getSqlCommandType();
		if (commondType.compareTo(SqlCommandType.SELECT) == 0) {
			return "select";
		}
		if (commondType.compareTo(SqlCommandType.INSERT) == 0) {
			return "insert";
		}
		if (commondType.compareTo(SqlCommandType.UPDATE) == 0) {
			return "update";
		}
		if (commondType.compareTo(SqlCommandType.DELETE) == 0) {
			return "delete";
		}
		return null;
	}

	/**
	 * 定义一个内部辅助类，作用是包装SQL
	 */
	class BoundSqlSqlSource implements SqlSource {

		private BoundSql boundSql;

		private BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		@Override
		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}
}
