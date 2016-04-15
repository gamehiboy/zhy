package com.sibu.xinweishang.api.service;


import java.util.List;
import java.util.Set;

import com.sibu.xinweishang.api.model.Role;

/**
* @ClassName: RoleService
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
public interface RoleService {


    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
//    public List<Role> findPage(Page<Role> p);

    /**
     * 根据角色编号得到角色标识符列�?
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列�?
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
