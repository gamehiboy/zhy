package com.sibu.xinweishang.api.dao;


import java.util.List;
import java.util.Map;

import com.sibu.xinweishang.api.model.Authorization;

/**
 * 
* @ClassName: AuthorizationMapper 
* @Description: 权限
* @author zhy(505177876@qq.com)
* @date 2016年3月11日 下午1:58:16 
*
 */
public interface AuthorizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Authorization record);

    int insertSelective(Authorization record);

    Authorization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Authorization record);

    int updateByPrimaryKey(Authorization record);
    
    public List<Authorization> selectAll();
    
//    public List<Authorization> selectPage(Page<Authorization> p);

    public Authorization selectByAppUser(Map<String,Object> map);
    
}