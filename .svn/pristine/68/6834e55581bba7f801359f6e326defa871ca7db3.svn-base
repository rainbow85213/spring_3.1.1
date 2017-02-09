package com.han.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.han.db.common.PagingUtil;
import com.han.db.dao.DatabaseDao;
import com.han.db.vo.TestVo;

@Component
public class DatabaseDaoImpl implements DatabaseDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;

	public Object excuteQuery(String namespace, String id, Object object) {
		return sqlSessionTemplate.selectOne(namespace + "." + id, object);
	}

	public Object excuteQueryList(String namespace, String id, Object object) {
		return sqlSessionTemplate.selectList(namespace + "." + id, object);
	}
	
	public Object excuteQueryListLimit(String namespace, String id, Object object, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(namespace + "." + id, object, rowBounds);
	}
	
	public int excuteUpdate(String namespace, String id, Object object) {
		
		if(id.contains("insert")){
			return sqlSessionTemplate.insert(namespace + "." + id, object);
		}else if(id.contains("update")){
			return sqlSessionTemplate.update(namespace + "." + id, object);
		}else if(id.contains("delete")){
			return sqlSessionTemplate.delete(namespace + "." + id, object);
		}
		
		return -1;
	}
	/*
	public Map<String, Object> getPagingList(String namespace, String id, TestVo testVo) {
		Map<String, Object> service = new HashMap<String, Object>();
		
		int totalcnt = sqlSessionTemplate.selectOne(namespace + "." + id + "Cnt", testVo);
		PagingUtil pageInfo = new PagingUtil(testVo.getPage(), totalcnt, testVo.getPageSize(), testVo.getBlock_page(), testVo.getPaging_script());

		int offset = pageInfo.getPageStart();
		int limit = pageInfo.getPageEnd();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Object> searchList = sqlSessionTemplate.selectList(namespace + "." + id, testVo, rowBounds);
		
		service.put("pageInfo", pageInfo);
		service.put("totalcnt", totalcnt);
		service.put("list", searchList);
		
		return service;
	}
	 */
}