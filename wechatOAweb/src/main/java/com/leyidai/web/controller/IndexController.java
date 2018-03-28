package com.leyidai.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端Controller
 * 
 * @author Administrator
 * 
 */
@Controller
public class IndexController extends BaseController {

	@Value("#{systemConfigProperties[defaultArea]}")
	private String defaultArea;
	private static Logger log = Logger.getLogger(IndexController.class);

	/* 2017-1-9 add start */
	/**
	 * 系统维护页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemMaintenance")
	public String systemMaintenance() {
		return "/systemMaintenance";
	}

}
