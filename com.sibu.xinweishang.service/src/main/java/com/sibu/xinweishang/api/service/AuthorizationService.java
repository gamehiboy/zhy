package com.sibu.xinweishang.api.service;


import java.util.List;
import java.util.Set;

import com.sibu.xinweishang.api.model.Authorization;
import com.sibu.xinweishang.common.data.Pager;

public interface AuthorizationService {


    public Authorization createAuthorization(Authorization authorization);
    public Authorization updateAuthorization(Authorization authorization);
    public void deleteAuthorization(Long authorizationId);

    public Authorization findOne(Long authorizationId);
    public List<Authorization> findAll();
//    public List<Authorization> findPage(Pager<Authorization> p);

    /**
     * 根据AppKey和用户名查找其角�?
     * @param username
     * @return
     */
    public Set<String> findRoles(String appKey, String username);

    /**
     * 根据AppKey和用户名查找权限字符�?
     * @param username
     * @return
     */
    public Set<String> findPermissions(String appKey, String username);


}
