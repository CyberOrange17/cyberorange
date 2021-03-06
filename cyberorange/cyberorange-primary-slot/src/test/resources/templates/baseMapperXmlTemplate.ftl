<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${javaMapperBasePackageName}.Base${javaPascalName}Mapper" >
	
	<!-- 通用查询映射结果 -->
	<resultMap id="BaseResultMap" type="${javaEntityPackageName}.${javaPascalName}Entity">
	<#list columnList as column>
		<#if column.javaCamelName == "id">
		<id column="${column.mysqlColumnName}" jdbcType="${column.mysqlDataType}" property="${column.javaCamelName}"/>
		<#else>
		<result column="${column.mysqlColumnName}" jdbcType="${column.mysqlDataType}" property="${column.javaCamelName}"/>
		</#if>
	</#list>
	</resultMap>
	
	<!-- 通用查询结果列 -->
	<sql id="BaseColumnList" >
		<#list columnList as column>
		<#if column_has_next>
		${column.mysqlColumnName},
		<#else>
		${column.mysqlColumnName}
		</#if>
		</#list>
    </sql>
    
  	<!-- 插入一个实体对象 -->
    <insert id="insert" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
	    insert into
		`${mysqlTableAlias}`
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id")>
    	<#if (column_has_next)>
        	${column.mysqlColumnName},
		<#else>
			${column.mysqlColumnName}
		</#if>    	
        </#if>
		</#list>
		) values(
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id")>
    	<#if (column_has_next)>
        	${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		<#else>
			${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}}
		</#if>    	
        </#if>
		</#list>
	    )
  	</insert>
    
  	<!-- 批量插入实体对象 -->
    <insert id="batchInsert" parameterType="java.util.List">
	    insert into
		`${mysqlTableAlias}`
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id")>
    	<#if (column_has_next)>
        	${column.mysqlColumnName},
		<#else>
			${column.mysqlColumnName}
		</#if>
        </#if>
		</#list>
		) values
	    <foreach collection="list" item="item" index="index" open="" close="" separator=",">
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id")>
    	<#if (column_has_next)>
        	${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		<#else>
			${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}}
		</#if>
        </#if>
		</#list>
        )
		</foreach>
  	</insert>
    
  	<!-- 根据ID更新实体对象 -->
  	<update id="updateById" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
  		update
		${mysqlTableAlias}
    	<set>
    	<#list columnList as column>
    	<#if (column.javaCamelName != "id")>
	    	${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		</#if>
		</#list>
			ID = ${hash}{id}
    	</set>
		where ID = ${hash}{id}
  	</update>
  	
  	<!-- 批量根据ID更新实体对象 -->
  	<update id="batchUpdateById" parameterType="java.util.List">
	    <foreach collection="list" item="item" index="index" open="" close="" separator=";">
		    update
			`${mysqlTableAlias}`
	    	<set>
	    	<#list columnList as column>
	    	<#if (column.javaCamelName != "id")>
        		${column.mysqlColumnName}=${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
			</#if>
			</#list>
				ID = ${hash}{item.id}
	    	</set>
			where ID = ${hash}{item.id}
		</foreach>
  	</update>
  	
  	<!-- 根据ID更新实体对象的有效属性 -->
  	<update id="updateSelectiveById" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
  		update
		${mysqlTableAlias}
    	<set>
    	<#list columnList as column>
    	<#if (column.javaCamelName != "id")>
      		<if test="${column.javaCamelName} != null">
        		${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
      		</if>
		</#if>
		</#list>
      		ID = ${hash}{id}
    	</set>
		where ID = ${hash}{id}
  	</update>
  	
  	<!-- 批量根据ID更新实体对象的有效属性 -->
  	<update id="batchUpdateSelectiveById" parameterType="java.util.List">
  		<foreach collection="list" item="item" index="index" open="" close="" separator=";">
	  		update
			`${mysqlTableAlias}`
	    	<set>
	    	<#list columnList as column>
	    	<#if (column.javaCamelName != "id")>
        		<if test="item.${column.javaCamelName} != null">
	        		${column.mysqlColumnName}=${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
	      		</if>
			</#if>
			</#list>
	      		 ID = ${hash}{item.id}
	    	</set>
			where ID = ${hash}{item.id}
		</foreach>
  	</update>
  	
  	<!-- 根据ID查询记录 -->
  	<select id="selectById" parameterType="java.lang.Integer" resultMap="BaseResultMap">
	    select 
	    <include refid="BaseColumnList" />
	    from
		${mysqlTableAlias}
	    where ID = ${hash}{id} limit 1
  	</select>
  	
  	<!-- 根据实体可用的字段查询列表 -->
  	<select id="selectListSelective" parameterType="${javaEntityPackageName}.${javaPascalName}Entity" resultMap="BaseResultMap">
	    select 
	    <include refid="BaseColumnList" />
	    from
		${mysqlTableAlias}
	    where
	    	1 = 1 
	    	<#list columnList as column>
		    <if test="${column.javaCamelName} != null">
		    and ${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}} 
		    </if>
			</#list>
  	</select>
  	
  	<!-- 根据实体可用的字段查询一条数据 -->
  	<select id="selectOneSelective" parameterType="${javaEntityPackageName}.${javaPascalName}Entity" resultMap="BaseResultMap">
	    select 
	    <include refid="BaseColumnList" />
	    from
		${mysqlTableAlias}
	    where
	    	1 = 1
	    	<#list columnList as column>
	    	<if test="${column.javaCamelName} != null">
	        and ${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}} 
	      	</if>
			</#list>
	    limit 1
  	</select>
  	
  	<!-- 根据ID删除记录 -->
  	<delete id="deleteById" parameterType="java.lang.Integer">
		delete from
		${mysqlTableAlias}
		where ID = ${hash}{id}
  	</delete>
  	
  	<!-- 批量根据ID删除记录 -->
  	<delete id="batchDeleteById" parameterType="java.util.List">
		delete from
		`${mysqlTableAlias}`
		where ID in 
		<foreach collection="list" item="item" index="index" open="(" close=")" separator=",">
	    	${hash}{item}
		</foreach>
  	</delete>
  	
</mapper>