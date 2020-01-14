package com.cyberorange.service.basics.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cyberorange.mapper.basics.BasicsMapper;
import com.cyberorange.service.basics.BasicsService;

/**
 * 基础操作实现类
 * 
 * @author 黄传举
 */
public class BasicsServiceImpl<M extends BasicsMapper<T>, T> implements BasicsService<T> {

	@Autowired
	public M basicsMapper;

	@Override
	public void insert(T t) {
		if (t != null)
			basicsMapper.insert(t);
	}

	@Override
	public void batchInsert(List<T> list) {
		if (list != null && !list.isEmpty())
			basicsMapper.batchInsert(list);
	}

	@Override
	public void updateById(T t) {
		if (t != null)
			basicsMapper.updateById(t);
	}

	@Override
	public void batchUpdateById(List<T> list) {
		if (list != null && !list.isEmpty())
			basicsMapper.batchUpdateById(list);
	}

	@Override
	public void updateSelectiveById(T t) {
		if (t != null)
			basicsMapper.updateSelectiveById(t);
	}

	@Override
	public void batchUpdateSelectiveById(List<T> list) {
		if (list != null && !list.isEmpty())
			basicsMapper.batchUpdateSelectiveById(list);
	}

	@Override
	public T selectById(Long id) {
		if (id != null)
			basicsMapper.selectById(id);
		return null;
	}

	@Override
	public T selectOneSelective(T t) {
		if (t != null)
			basicsMapper.selectOneSelective(t);
		return null;
	}

	@Override
	public List<T> selectListSelective(T t) {
		if (t != null)
			basicsMapper.selectListSelective(t);
		return new ArrayList<>();
	}

	@Override
	public void deleteById(Long id) {
		if (id != null)
			basicsMapper.deleteById(id);
	}

	@Override
	public void batchDeleteById(List<Long> list) {
		if (list != null && !list.isEmpty())
			basicsMapper.batchDeleteById(list);
	}

}
