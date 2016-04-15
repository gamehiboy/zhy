package com.sibu.xinweishang.api.dao;


import java.util.List;

import com.sibu.xinweishang.api.model.Role;


/**
 * 
* @ClassName: RoleMapper 
* @Description: 角色
* @author zhy(505177876@qq.com)
* @date 2016年3月11日 下午1:58:16 
*
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAll();
    
//    List<Role> selectPage(Page<Role> p);
}