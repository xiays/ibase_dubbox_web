package com.ibase.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ibase.api.IUser;
import com.ibase.entity.UserInfo;

@Controller
@RequestMapping(value="/user")
public class UserController {

	//@SuppressWarnings("unused")
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Reference
	private IUser userService;

	@RequestMapping(value="/")
	public String Index(HttpServletRequest request) {
		System.out.println("xxxxx");
	    //UserInfo info = userService.selectbyid(5);
		//System.out.println(info.getUsername());
		UserInfo info1 =new UserInfo();
		PageInfo<UserInfo> list= userService.selectBypage(info1, 1, 15);
		
		//System.out.println(info.getId()+"");
		System.out.println(list.getPageSize()+"");
		List<UserInfo> list1=list.getList();		
		System.out.println(list1.get(2).getUsername());
		//logger.trace(info.getUsername());
		request.setAttribute("list", list1);
		return "index";
	}
}
