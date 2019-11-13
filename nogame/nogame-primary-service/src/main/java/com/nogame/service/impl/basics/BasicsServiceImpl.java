package com.nogame.service.impl.basics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nogame.mapper.basics.BasicsMapper;
import com.nogame.service.basics.BasicsService;

/**
 * 基础操作实现类
 * 
 * @author 黄传举
 */
@Service
public class BasicsServiceImpl<T> implements BasicsService<T> {

	@Autowired
	private BasicsMapper<T> basicsMapper;

	@Override
	public int insert(T t) {
		if (null == t) return 0;
		return basicsMapper.insert(t);
	}

	@Override
	public void update(T t) {
		if (null == t) return;
		basicsMapper.update(t);
	}

	@Override
	public void deleteById(Long id) {
		if (null == id) return;
		basicsMapper.deleteById(id);
	}

	@Override
	public void deleteByEntity(T t) {
		if (null == t) return;
		basicsMapper.deleteByEntity(t);
	}

	@Override
	public T selectById(Long id) {
		if (null == id) return null;
		return basicsMapper.selectById(id);
	}

	@Override
	public T selectOneByEntity(T t) {
		if (null == t) return null;
		return basicsMapper.selectOneByEntity(t);
	}

	@Override
	public List<T> selectListByEntity(T t) {
		if (null == t) return null;
		return basicsMapper.selectListByEntity(t);
	}
	

	@Override
	public void saveOrUpdate(T t, Long id) {
		if (null == id) {
			basicsMapper.insert(t);
		}else {
			basicsMapper.update(t);
		}
	}
}
