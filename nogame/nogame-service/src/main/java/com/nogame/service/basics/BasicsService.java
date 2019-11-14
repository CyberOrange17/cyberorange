package com.nogame.service.basics;

import java.util.List;

/**
 * 基础操作接口
 * 
 * @author 黄传举
 */
public interface BasicsService<T> {

	/**
	 * 插入一个实体对象
	 * 
	 * @param t
	 * @return
	 */
	void insert(T t);

	/**
	 * 批量插入实体对象
	 * 
	 * @param list
	 */
	void batchInsert(List<T> list);

	/**
	 * 根据ID更新实体对象
	 * 
	 * @param t
	 */
	void updateById(T t);

	/**
	 * 批量根据ID更新实体对象
	 * 
	 * @param list
	 */
	void batchUpdateById(List<T> list);

	/**
	 * 根据ID更新实体对象的有效属性
	 * 
	 * @param t
	 */
	void updateSelectiveById(T t);

	/**
	 * 批量根据ID更新实体对象的有效属性
	 * 
	 * @param list
	 */
	void batchUpdateSelectiveById(List<T> list);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	T selectById(Long id);

	/**
	 * 根据实体可用的字段查询一条数据
	 * 
	 * @param t
	 * @return
	 */
	T selectOneSelective(T t);

	/**
	 * 根据实体可用的字段查询多条记录
	 * 
	 * @param t
	 * @return
	 */
	List<T> selectListSelective(T t);

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 批量根据ID删除记录
	 * 
	 * @param list
	 */
	void batchDeleteById(List<Long> list);
}
