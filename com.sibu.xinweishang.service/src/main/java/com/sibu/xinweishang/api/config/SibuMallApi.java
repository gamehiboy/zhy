package com.sibu.xinweishang.api.config;


/**
* @ClassName: SibuMallApi
* @Description: 商城API请求
* @author zhy
* @date 2016年3月11日 上午10:02:56
* 版本：V2.0
*/ 
public class SibuMallApi {
	
	//api请求的url
	private static String MALL_API_URL = "http://testapi.sibucloud.com/api/";
	
	//======================【产品分类api】=========================================
	//获取产品分类列表
	public static String GET_ALL_CATEGORY = MALL_API_URL+"category/list?version=1.0";
}
