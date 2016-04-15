package com.sibu.xinweishang.api.dao;


import java.util.List;

import com.sibu.xinweishang.api.model.App;

/**
 * 
* @ClassName: AppMapper 
* @Description: 应用
* @author zhy(505177876@qq.com)
* @date 2016年3月11日 下午1:58:16 
*
*
 */
public interface AppMapper {
    int deleteByPrimaryKey(Long id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
    
    List<App> selectAll();
    
//    List<App> selectPage(Page<App> p);
    
    Long selectAppIdByAppKey(String appKey);
}