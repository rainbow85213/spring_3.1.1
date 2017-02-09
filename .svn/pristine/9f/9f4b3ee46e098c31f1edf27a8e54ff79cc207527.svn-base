package com.han.db.common;

public class PagingUtil{
	
	private final int MAX_PAGE_SIZE = 1000;
	
	private int page;
	private int total_cnt;
	private int block_page;
	
	private int page_size;
	private int page_start;
	private int page_end;
	
	private int start_page;
	private int end_page;
	private int total_page;
	
	private String paging_script;
	
	private PagingUtil(int page_size){
		
		this.page_size = (page_size > MAX_PAGE_SIZE) ? MAX_PAGE_SIZE : page_size;
	}
	
	public PagingUtil(int page, int total_cnt, int page_size, int block_page, String paging_script){
		
		this(page_size);
		
		this.page = page;
		this.total_cnt = total_cnt;
		this.block_page = block_page;
		this.paging_script = paging_script;
		
		total_page = (total_cnt - 1) / this.page_size + 1;
		
		start_page = ((page - 1) / block_page) * block_page + 1;
		end_page = start_page + block_page - 1;
		
		if(total_page < end_page){
			
			end_page = total_page;
		}
		
		page_start = (page - 1) * this.page_size;
		page_end = page_size;
	}
	
	public PagingUtil(int page, int page_size, int block_page, String paging_script){
		
		this(page_size);
		
		this.page = page;
		this.block_page = block_page;
		this.paging_script = paging_script;
		
		page_start = (page - 1) * this.page_size;
		page_end = page_size;
	}
	
	public void setTotalCnt(int total_cnt){
		
		this.total_cnt = total_cnt;
		
		total_page = (total_cnt - 1) / page_size + 1;
		
		start_page = ((page - 1) / block_page) * block_page + 1;
		end_page = start_page + block_page - 1;
		
		if(total_page < end_page){
			
			end_page = total_page;
		}
	}
	
	public int getPageSize(){
		
		return page_size;
	}
	
	public int getPageStart(){
		
		return page_start;
	}
	
	public int getPageEnd(){
		
		return page_end;
	}
	
	public int getTotalCnt(){
		
		return total_cnt;
	}
	
	private String getScript(int move_page){
		
		String script = "javascript:" + paging_script + "(" + move_page + ");";
		
		return script;
	}

	public String getPagingHtml(){
		
		/*
				<a href="#" class="btn prev">이전으로</a>
				<span class="num">
					<a href="#" class="on">1</a>
					<!-- 현재페이지 class="on" 추가/ <span class="hidden">현재 페이지:</span> 코드 추가 -->
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">6</a>
					<a href="#">7</a>
					<a href="#">8</a>
					<a href="#">9</a>
					<a href="#">10</a>
				</span>
				<a href="#" class="btn next">다음으로</a>
		 * */
		int prev_page_num = (page > block_page) ? start_page - 1 : page;
		int next_page_num = ((end_page + 1) <= total_page) ? (end_page + 1) : page;
		
		//String first_page = "<a class=\"btn prev\" href=\"" + getScript(1) + "\">First Page</a>";
		String prev_page  = "<a class=\"btn prev\" href=\"" + getScript(prev_page_num) + "\">이전으로</a>";
		
		String next_page  = "<a class=\"btn next\" href=\"" + getScript(next_page_num) + "\">다음으로</a>";
		//String last_page  = "<a class=\"btn next\" href=\"" + getScript(total_page) + "\">End Page</a>";
		
		// make paging html
		StringBuffer html = new StringBuffer();
		
		//html.append(first_page);
		html.append(prev_page);
		html.append("<span class=\"num\">");
		
		for(int i=start_page; i<=end_page; i++){
			
			if(page == i){
				
				html.append("<a class=\"on\">" + i + "</a>");
			}
			else{
				
				html.append("<a href=\""+ getScript(i) + "\">" + i + "</a>");
			}
		}
		
		html.append("</span>");
		html.append(next_page);
		//html.append(last_page);
		
		return html.toString();
	}
}