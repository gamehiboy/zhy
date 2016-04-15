package com.sibu.xinweishang.wechat.service;


import org.springframework.stereotype.Service;

import com.sibu.xinweishang.api.config.SibuMallApi;
import com.sibu.xinweishang.common.util.HttpclientUtil;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	public String getCategoryList() throws Exception {
		return HttpclientUtil.get(SibuMallApi.GET_ALL_CATEGORY);
	}
	
}
