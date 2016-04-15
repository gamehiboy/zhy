package com.sibu.xinweishang.api.dao;


import java.util.List;

import com.sibu.xinweishang.api.model.Resource;


/**
 * 
* @ClassName: ResourceMapper 
* @Description: 资源
* @author zhy(505177876@qq.com)
* @date 2016年3月11日 下午1:58:16 
*
*
 */
public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> selectAll();
}