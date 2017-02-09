package com.han.db.dao;

import java.util.Map;

import com.han.db.vo.TestVo;


public interface DatabaseDao {

	public Object excuteQuery(String namespace, String id, Object object);
	public Object excuteQueryList(String namespace, String id, Object object);
	public Object excuteQueryListLimit(String namespace, String id, Object object, int offset, int limit);
	public int excuteUpdate(String namespace, String id, Object object);
//	public Map<String, Object> getPagingList(String namespace, String id, TestVo testVo);
	
}