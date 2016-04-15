package com.sibu.xinweishang.api.service;


import java.util.List;

import com.sibu.xinweishang.api.model.App;
import com.sibu.xinweishang.common.data.Pager;

/**
* @ClassName: AppService
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
public interface AppService {


    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    public List<App> findPage(Pager<App> p);
    
    /**
     * 根据appKey查找AppId
     * @param appKey
     * @return
     */
    public Long findAppIdByAppKey(String appKey);
}
