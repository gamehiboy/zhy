package com.sibu.xinweishang.api.dao;


import java.util.List;
import java.util.Map;

import com.sibu.xinweishang.api.model.Organization;


/**
 * 
* @ClassName: OrganizationMapper 
* @Description: 组织
* @author zhy(505177876@qq.com)
* @date 2016年3月11日 下午1:58:16 
*
*
 */
public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    List<Organization> selectAll();

    List<Organization> selectAllWithExclude(Map<String,Object> map);

    int moveStepOne(Map<String,Object> map);
    
    int moveStepTwo(Map<String,Object> map);
}