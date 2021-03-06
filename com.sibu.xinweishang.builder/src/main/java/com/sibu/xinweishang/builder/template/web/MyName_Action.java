package com.sibu.xinweishang.builder.template.web;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.runner.Version;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sibu.xinweishang.builder.template.bean.MyName_Bean;
import com.sibu.xinweishang.builder.template.service.MyName_Service;
import com.sibu.xinweishang.common.data.ResponseUtil;
import com.sibu.xinweishang.common.util.JacksonUtil;
import com.sibu.xinweishang.common.util.StringUtil;

/**
 * MyName_Action
 * @version 1.0
 * @author 作者_
 */
@Controller
@RequestMapping(value = "/login",produces="application/json")
public class MyName_Action {
	
	/** 用户服务接口 */
	@Resource
	MyName_Service myName_Service;
	
	/**
	 * 查询分页
	 * @param param  参数值
	 * @param page   页码
	 * @param size   页数
	 * @param version  接口版本号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@ResponseBody
	public String list(String id, String page, String size, String version,HttpServletRequest req, HttpServletResponse res) throws Exception{
		String module="";
		///List<MyName_Bean> list = myName_Service.list(null,module);
		return ResponseUtil.data(null);
	}
	
	
	
	/**
	 * 增加 json 格式传送
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/addJson", method = RequestMethod.POST)
	@ResponseBody
	public String addJson(String param,String version,HttpServletRequest req, HttpServletResponse res) throws Exception{
		String module="";
		MyName_Bean _brean = JacksonUtil.fromJson(param, MyName_Bean.class);
		if(_brean == null){
			return ResponseUtil.error("参数错误");
		}
		//myName_Service.save(_brean,module);
		return ResponseUtil.success(); 
	}
	
	/**
	 * 对象传送数据 
	 * @param bean      对象
	 * @param version   版本号
	 * @param req       
	 * @param res
	 * @return			json格式
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(MyName_Bean bean,String version,HttpServletRequest req, HttpServletResponse res) throws Exception{
		String module="";
		//myName_Service.save(bean,module);
		return ResponseUtil.success(); 
	}
	
	/**
	 * 获取 对象
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET) 
	@ResponseBody
	public String get(String param,String version,HttpServletRequest req, HttpServletResponse res) throws Exception{
		String module="";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", param);
		if(!StringUtil.isNull(params)){
			//MyName_Bean ub = myName_Service.get(params,module);
			return ResponseUtil.data(null);
		}else{
			return ResponseUtil.error();
		}
	}
	 
	/**
	 * 保存编辑数据
	 * @param bean
	 * @param rel
	 * @param model
	 * @param req
	 * @param res
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPOST(String id, String version, HttpServletRequest req, HttpServletResponse res) throws Exception{
		String module="";
		MyName_Bean _brean = JacksonUtil.fromJson(id, MyName_Bean.class);
		if(_brean == null){
			return ResponseUtil.error("address参数错误");
		}
		//myName_Service.update(_brean,module);
		return ResponseUtil.success();
	}
	
	/**
	 * 删除数据
	 * @param id
	 * @param res
	 * @throws Exception
	 */
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	public String del(String id,String version, HttpServletResponse res) throws Exception{
		String module="";
		//myName_Service.deleteById(id,module);
		return ResponseUtil.success(); 
	}
	
}
