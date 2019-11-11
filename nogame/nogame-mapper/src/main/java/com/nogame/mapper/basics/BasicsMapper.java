package com.nogame.mapper.basics;

import java.util.List;

public interface BasicsMapper<T> {
	
	/**
	 * 新增一条记录
	 * 
	 * @param t
	 * @return
	 */
	int insert(T t);

	/**
	 * 根据id修改记录
	 * 
	 * @param t
	 */
	void update(T t);

	/**
	 * 根据id删除一条记录
	 * 
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 根据实体删除记录
	 * 
	 * @param t
	 */
	void deleteByEntity(T t);

	/**
	 * 根据Id查询一条记录
	 * 
	 * @param id
	 * @return
	 */
	T selectById(Long id);

	/**
	 * 根据实体查询一条记录
	 * 
	 * @param t
	 * @return
	 */
	T selectOneByEntity(T t);
	
	/**
	 * 根据实体查询多条记录
	 * @param t
	 * @return
	 */
	List<T> selectListByEntity(T t);
	
}
