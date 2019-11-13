package com.nogame.service.basics;

import java.util.List;

/**
 * 基础操作接口
 * 
 * @author 黄传举
 */
public interface BasicsService<T> {
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
	 * @return
	 */
	List<T> selectListByEntity(T t);

	/**
	 * 根据id保存或修改一条记录
	 * 
	 * @param t
	 * @param id
	 */
	void saveOrUpdate(T t, Long id);
}
