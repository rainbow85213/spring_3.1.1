package com.han.db.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.han.db.common.PagingUtil;
import com.han.db.dao.DatabaseDao;
import com.han.db.vo.TestVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DatabaseDao databaseDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model, TestVo paramVo) {
		return "home";
	}

	@RequestMapping(value = "/list.do")
	public String list(Locale locale, Model model, TestVo paramVo) {
		
		int listCnt = (Integer) databaseDao.excuteQuery("testMapper", "selectTestListCnt", paramVo);
		PagingUtil paging = new PagingUtil(paramVo.getPage(), listCnt, paramVo.getPageSize(), paramVo.block_page, paramVo.paging_script);
		List<TestVo> testList = (List<TestVo>) databaseDao.excuteQueryListLimit("testMapper", "selectTestList", paramVo, paging.getPageStart(), paramVo.getPageSize());
		
		model.addAttribute("testList", testList);
		model.addAttribute("paging", paging);
		return "view:list";
	}
	
	@RequestMapping(value = "/info.do")
	public String info(Locale locale, Model model, TestVo paramVo) {
		
		databaseDao.excuteUpdate("testMapper", "updateTestCnt", paramVo);
		TestVo testInfo = (TestVo) databaseDao.excuteQuery("testMapper", "selectTestInfo", paramVo);
		
		model.addAttribute("testInfo", testInfo);
		return "view:info";
	}
	
}