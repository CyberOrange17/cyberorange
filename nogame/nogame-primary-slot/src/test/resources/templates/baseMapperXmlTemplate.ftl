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
    
	<!-- 通用查询条件 -->
	<sql id="BaseColumnWhere">
	    where TENANT_ID = '{tenant_id}'
		<if test="conditionList != null and conditionList.size() > 0">
			<foreach collection="conditionList" item="condition" index="index" open="" close="" separator=" ">
				<choose>
					<when test="condition.noValue">
						${dollar}{condition.union} ${dollar}{condition.leftBracket} ${dollar}{condition.column} ${dollar}{condition.operator} ${dollar}{condition.rightBracket}
					</when>
					<when test="condition.singleValue">
	                	${dollar}{condition.union} ${dollar}{condition.leftBracket} ${dollar}{condition.column} ${dollar}{condition.operator} ${hash}{condition.value} ${dollar}{condition.rightBracket}
	                </when>
	                <when test="condition.listValue">
	                	${dollar}{condition.union} ${dollar}{condition.leftBracket} ${dollar}{condition.column} ${dollar}{condition.operator}
	                  	<foreach collection="condition.value" item="v" open="(" close=")" separator=",">
	                    	${hash}{v}
	                    </foreach>
	                  	${dollar}{condition.rightBracket}
	                </when>
	            </choose>
	        </foreach>
		</if>
	</sql>
    
  	<!-- 插入一个实体对象 -->
    <insert id="insert" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
	    insert into
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
        	${column.mysqlColumnName},
        </#if>
		</#list>
			TENANT_ID
		) values(
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
        	${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
        </#if>
		</#list>
        	'{tenant_id}'
	    )
  	</insert>
    
  	<!-- 批量插入实体对象 -->
    <insert id="batchInsert" parameterType="java.util.List">
	    insert into
	    <#if javaModuleName == "pos">
		`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
		<#else>
		`${mysqlTableAlias}_{tenant_id}`
		</#if>
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
        	${column.mysqlColumnName},
        </#if>
		</#list>
			TENANT_ID
		) values
	    <foreach collection="list" item="item" index="index" open="" close="" separator=",">
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
        	${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
        </#if>
		</#list>
        	'{tenant_id}'
        )
		</foreach>
  	</insert>
    
  	<!-- 插入一个实体对象的有效属性 -->
    <insert id="insertSelective" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
	    insert into
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    (
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
			<if test="${column.javaCamelName} != null">
	        	${column.mysqlColumnName},
	      	</if>
	    </#if>
		</#list>
			TENANT_ID
	    ) values(
	    <#list columnList as column>
	    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
			<if test="${column.javaCamelName} != null">
	        	${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
	      	</if>
	    </#if>
		</#list>
        	'{tenant_id}'
	    )
  	</insert>
    
  	<!-- 批量插入实体对象的有效属性 -->
    <insert id="batchInsertSelective" parameterType="java.util.List">
	    <foreach collection="list" item="item" index="index" open="" close="" separator=";">
		    insert into
		    <#if javaModuleName == "pos">
			`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
			<#else>
			`${mysqlTableAlias}_{tenant_id}`
			</#if>
		    (
		    <#list columnList as column>
		    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
				<if test="item.${column.javaCamelName} != null">
		        	${column.mysqlColumnName},
		      	</if>
		    </#if>
			</#list>
				TENANT_ID
		    ) values (
		    <#list columnList as column>
		    <#if (column.javaCamelName != "id") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "updateTime")>
				<if test="item.${column.javaCamelName} != null">
		        	${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		      	</if>
		    </#if>
			</#list>
	        	'{tenant_id}'
	        )
		</foreach>
  	</insert>
  	
  	<!-- 根据ID删除记录 -->
  	<delete id="deleteById" parameterType="java.lang.Integer">
		delete from
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
		where TENANT_ID = '{tenant_id}' and ID = ${hash}{id}
  	</delete>
  	
  	<!-- 批量根据ID删除记录 -->
  	<delete id="batchDeleteById" parameterType="java.util.List">
		delete from
	    <#if javaModuleName == "pos">
		`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
		<#else>
		`${mysqlTableAlias}_{tenant_id}`
		</#if>
		where TENANT_ID = '{tenant_id}' and ID in 
		<foreach collection="list" item="item" index="index" open="(" close=")" separator=",">
	    	${hash}{item}
		</foreach>
  	</delete>
  	
  	<!-- 根据UID删除记录 -->
  	<delete id="deleteByUid" parameterType="java.lang.String">
		delete from
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
		where TENANT_ID = '{tenant_id}' and UID = ${hash}{uid}
  	</delete>
  	
  	<!-- 批量根据UID删除记录 -->
  	<delete id="batchDeleteByUid" parameterType="java.util.List">
		delete from
	    <#if javaModuleName == "pos">
		`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
		<#else>
		`${mysqlTableAlias}_{tenant_id}`
		</#if>
		where TENANT_ID = '{tenant_id}' and UID in
		<foreach collection="list" item="item" index="index" open="(" close=")" separator=",">
	    	${hash}{item}
		</foreach>
  	</delete>
  	
  	<!-- 根据ID更新实体对象 -->
  	<update id="updateById" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
  		update
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
    	<set>
    	<#list columnList as column>
    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
			${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		</#if>
		</#list>
    	</set>
		where TENANT_ID = '{tenant_id}' and ID = ${hash}{id}
  	</update>
  	
  	<!-- 批量根据ID更新实体对象 -->
  	<update id="batchUpdateById" parameterType="java.util.List">
	    <foreach collection="list" item="item" index="index" open="" close="" separator=";">
		    update
		    <#if javaModuleName == "pos">
			`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
			<#else>
			`${mysqlTableAlias}_{tenant_id}`
			</#if>
	    	<set>
	    	<#list columnList as column>
	    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
				${column.mysqlColumnName}=${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
			</#if>
			</#list>
	    	</set>
			where TENANT_ID = '{tenant_id}' and ID = ${hash}{item.id}
		</foreach>
  	</update>
  	
  	<!-- 根据ID更新实体对象的有效属性 -->
  	<update id="updateSelectiveById" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
  		update
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
    	<set>
    	<#list columnList as column>
    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
	    	<if test="${column.javaCamelName} != null">
	        	${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
	      	</if>
		</#if>
		</#list>
    	</set>
		where TENANT_ID = '{tenant_id}' and ID = ${hash}{id}
  	</update>
  	
  	<!-- 批量根据ID更新实体对象的有效属性 -->
  	<update id="batchUpdateSelectiveById" parameterType="java.util.List">
  		<foreach collection="list" item="item" index="index" open="" close="" separator=";">
	  		update
		    <#if javaModuleName == "pos">
			`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
			<#else>
			`${mysqlTableAlias}_{tenant_id}`
			</#if>
	    	<set>
	    	<#list columnList as column>
	    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
		    	<if test="item.${column.javaCamelName} != null">
		        	${column.mysqlColumnName}=${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		      	</if>
			</#if>
			</#list>
	    	</set>
			where TENANT_ID = '{tenant_id}' and ID = ${hash}{item.id}
		</foreach>
  	</update>
  	
  	<!-- 根据UID更新实体对象 -->
  	<update id="updateByUid" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
  		update
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
    	<set>
    	<#list columnList as column>
    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
			${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		</#if>
		</#list>
    	</set>
		where TENANT_ID = '{tenant_id}' and UID = ${hash}{uid}
  	</update>
  	
  	<!-- 批量根据UID更新实体对象 -->
  	<update id="batchUpdateByUid" parameterType="java.util.List">
  		<foreach collection="list" item="item" index="index" open="" close="" separator=";">
	  		update
		    <#if javaModuleName == "pos">
			`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
			<#else>
			`${mysqlTableAlias}_{tenant_id}`
			</#if>
	    	<set>
	    	<#list columnList as column>
	    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
				${column.mysqlColumnName}=${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
			</#if>
			</#list>
	    	</set>
			where TENANT_ID = '{tenant_id}' and UID = ${hash}{item.uid}
		</foreach>
  	</update>
  	
  	<!-- 根据UID更新实体对象的有效属性 -->
  	<update id="updateSelectiveByUid" parameterType="${javaEntityPackageName}.${javaPascalName}Entity">
  		update
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
    	<set>
    	<#list columnList as column>
    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
	    	<if test="${column.javaCamelName} != null">
	        	${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}},
	      	</if>
		</#if>
		</#list>
    	</set>
		where TENANT_ID = '{tenant_id}' and UID = ${hash}{uid}
  	</update>
  	
  	<!-- 批量根据UID更新实体对象的有效属性 -->
  	<update id="batchUpdateSelectiveByUid" parameterType="java.util.List">
  		<foreach collection="list" item="item" index="index" open="" close="" separator=";">
	  		update
		    <#if javaModuleName == "pos">
			`${mysqlTableAlias}_{cinema_id}_{tenant_id}`
			<#else>
			`${mysqlTableAlias}_{tenant_id}`
			</#if>
	    	<set>
	    	<#list columnList as column>
	    	<#if (column.javaCamelName != "id") && (column.javaCamelName != "uid") && (column.javaCamelName != "tenantId") && (column.javaCamelName != "createTime") && (column.javaCamelName != "updateTime")>
		    	<if test="item.${column.javaCamelName} != null">
		        	${column.mysqlColumnName}=${hash}{item.${column.javaCamelName},jdbcType=${column.mysqlDataType}},
		      	</if>
			</#if>
			</#list>
	    	</set>
			where TENANT_ID = '{tenant_id}' and UID = ${hash}{item.uid}
		</foreach>
  	</update>
  	
  	<!-- 根据ID查询记录 -->
  	<select id="selectById" parameterType="java.lang.Integer" resultMap="BaseResultMap">
	    select 
	    <include refid="BaseColumnList" />
	    from
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    where TENANT_ID = '{tenant_id}' and ID = ${hash}{id} limit 1
  	</select>
  	
  	<!-- 根据UID查询记录 -->
  	<select id="selectByUid" parameterType="java.lang.String" resultMap="BaseResultMap">
	    select 
	    <include refid="BaseColumnList" />
	    from
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    where TENANT_ID = '{tenant_id}' and UID = ${hash}{uid} limit 1
  	</select>
  	
  	<!-- 根据实体可用的字段查询列表 -->
  	<select id="selectListSelective" parameterType="${javaEntityPackageName}.${javaPascalName}Entity" resultMap="BaseResultMap">
	    select 
	    <include refid="BaseColumnList" />
	    from
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    where
	    	TENANT_ID = '{tenant_id}'
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
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    where
	    	TENANT_ID = '{tenant_id}'
	    	<#list columnList as column>
	    	<if test="${column.javaCamelName} != null">
	        and ${column.mysqlColumnName}=${hash}{${column.javaCamelName},jdbcType=${column.mysqlDataType}} 
	      	</if>
			</#list>
	    limit 1
  	</select>
  	
  	<!-- 根据条件查询列表 -->
  	<select id="selectList" parameterType="com.oristartech.cim.core.mybatis.Criteria" resultMap="BaseResultMap">
	    select
	    <if test="distinct">
	      distinct
	    </if>
	    <include refid="BaseColumnList" />
	    from
	    <#if javaModuleName == "pos">
		${mysqlTableAlias}_{cinema_id}_{tenant_id}
		<#else>
		${mysqlTableAlias}_{tenant_id}
		</#if>
	    <include refid="BaseColumnWhere" />
	    <if test="orderby != null and orderby != ''">
	    	${dollar}{orderby}
	    </if>
  	</select>
  	
</mapper>