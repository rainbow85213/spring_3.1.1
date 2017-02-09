package com.han.db.vo;

import java.util.Map;

public class PagingVo{

	private int rownums;
	
	private int page;
	private int pageSize = 10;
	private int totalCnt;
	
	private int startPosition;
	private int endPosition;
	
	public int block_page = 10;
	public String paging_script	= "move_page";
	
	private Map<String, Object> search;

	
	
	public int getRownums() {
		return rownums;
	}

	public void setRownums(int rownums) {
		this.rownums = rownums;
	}

	public int getPage(){
		
		if(page == 0) page = 1;
		
		return page;
	}

	public void setPage(int page){
		
		this.page = (page == 0) ? 1 : page;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getTotalCnt(){
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt){
		this.totalCnt = totalCnt;
	}

	public int getStartPosition(){
		return startPosition;
	}

	public void setStartPosition(int startPosition){
		this.startPosition = startPosition;
	}

	public int getEndPosition(){
		return endPosition;
	}

	public void setEndPosition(int endPosition){
		this.endPosition = endPosition;
	}

	public Map<String, Object> getSearch(){
		return search;
	}

	public void setSearch(Map<String, Object> search){
		this.search = search;
	}

	public int getBlock_page() {
		return block_page;
	}

	public void setBlock_page(int block_page) {
		this.block_page = block_page;
	}

	public String getPaging_script() {
		return paging_script;
	}

	public void setPaging_script(String paging_script) {
		this.paging_script = paging_script;
	}

	
}