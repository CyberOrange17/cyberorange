package com.cyberorange.mapper.basics;

/**
 * 基础数据库操作
 * 
 * @author 黄传举
 */
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
	 * 根据实体删除
	 * 
	 * @param ids
	 */
	void deleteByEntity(T t);

	/**
	 * 根据id查询一条记录
	 * 
	 * @return
	 */
	T selectById();

	/**
	 * 根据实体查询一条记录
	 * 
	 * @param t
	 * @return
	 */
	T selectByEntity(T t);
}
