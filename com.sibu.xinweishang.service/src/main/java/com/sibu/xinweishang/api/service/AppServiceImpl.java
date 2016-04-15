package com.sibu.xinweishang.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibu.xinweishang.api.dao.AppMapper;
import com.sibu.xinweishang.api.model.App;
import com.sibu.xinweishang.common.data.Pager;

import java.util.List;

/**
* @ClassName: AppServiceImpl
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
@Service
public class AppServiceImpl implements AppService {

   /* @Autowired
    private AppDao appDao;*/
    
    @Autowired
    private AppMapper appMapper;

    public App createApp(App app) {
        appMapper.insertSelective(app);
        return app;
    }

    public App updateApp(App app) {
    	appMapper.updateByPrimaryKeySelective(app);
        return app;
    }

    public void deleteApp(Long appId) {
        appMapper.deleteByPrimaryKey(appId);
    }

    @Override
    public App findOne(Long appId) {    	
        return appMapper.selectByPrimaryKey(appId);
        
    }

    @Override
    public List<App> findAll() {    	
        return appMapper.selectAll();
    }

   /* public List<App> findPage(Pager<App> p){
    	  return appMapper.selectPage(p);
    }*/
    
    @Override
    public Long findAppIdByAppKey(String appKey) {    	
        return appMapper.selectAppIdByAppKey(appKey);
    }

	@Override
	public List<App> findPage(Pager<App> p) {
		// TODO Auto-generated method stub
		return null;
	}
}
