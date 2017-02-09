package com.han.db.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("testVo")
public @Data class TestVo extends PagingVo{

	String test_no;
	String test_title;
	String test_contents;
	String test_cnt;
	String reg_date;
	
	String searchType;
	String searchText;	
}
