package com.sibu.xinweishang.api.dao;


import java.util.List;
import java.util.Map;

import com.sibu.xinweishang.api.model.User;


/**
 * 
* @ClassName: UserMapper 
* @Description: 用户 
* @author zhy(505177876@qq.com)
* @date 2016年3月11日 下午1:58:16 
*
*
 */
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAll();
    
//    List<User> selectPage(Pager<User> p);

    User selectByUsername(Map<String,Object> map);
}