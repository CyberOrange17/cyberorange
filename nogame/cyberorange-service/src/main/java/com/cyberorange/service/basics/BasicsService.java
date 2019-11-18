package com.cyberorange.service.basics;

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
	public void insert(T t);

	/**
	 * 批量插入实体对象
	 * 
	 * @param list
	 */
	public void batchInsert(List<T> list);

	/**
	 * 根据ID更新实体对象
	 * 
	 * @param t
	 */
	public void updateById(T t);

	/**
	 * 批量根据ID更新实体对象
	 * 
	 * @param list
	 */
	public void batchUpdateById(List<T> list);

	/**
	 * 根据ID更新实体对象的有效属性
	 * 
	 * @param t
	 */
	public void updateSelectiveById(T t);

	/**
	 * 批量根据ID更新实体对象的有效属性
	 * 
	 * @param list
	 */
	public void batchUpdateSelectiveById(List<T> list);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public T selectById(Long id);

	/**
	 * 根据实体可用的字段查询一条数据
	 * 
	 * @param t
	 * @return
	 */
	public T selectOneSelective(T t);

	/**
	 * 根据实体可用的字段查询多条记录
	 * 
	 * @param t
	 * @return
	 */
	public List<T> selectListSelective(T t);

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 */
	public void deleteById(Long id);

	/**
	 * 批量根据ID删除记录
	 * 
	 * @param list
	 */
	public void batchDeleteById(List<Long> list);
}
