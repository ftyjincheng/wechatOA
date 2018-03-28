package com.leyidai.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Element;
import com.leyidai.entity.OrderRecords;
import com.leyidai.entity.User;
import com.leyidai.web.service.UserService;
import com.leyidai.web.util.DateUtil;
import com.leyidai.web.util.MessageUtil;
import com.leyidai.web.util.SiteUtil;

@Controller
public class UserController extends BaseController {
	private static final Logger log = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	
	
}
