package com.sibu.xinweishang.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibu.xinweishang.api.dao.RoleMapper;
import com.sibu.xinweishang.api.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @ClassName: RoleServiceImpl
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
@Service
public class RoleServiceImpl implements RoleService {

   /* @Autowired
    private RoleDao roleDao;*/
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceService resourceService;

    public Role createRole(Role role) {
    	roleMapper.insertSelective(role);
        return role;
    }

    public Role updateRole(Role role) {
    	roleMapper.updateByPrimaryKeySelective(role);
        return role;
    }

    public void deleteRole(Long roleId) {
    	roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
    	return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<Role> findAll() {
    	return roleMapper.selectAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
            	
            	//
            	 String[] resourceIdStrs = role.getResourceIds().split(",");
               for(String resourceIdStr : resourceIdStrs) {
                  if(resourceIdStr==null) {
                      continue;
                   }
                  resourceIds.add(Long.valueOf(resourceIdStr));
               }
            	//
            	
                //resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

	/*@Override
	public List<Role> findPage(Page<Role> p) {
		// TODO Auto-generated method stub
		return roleMapper.selectPage(p);
	}*/
}
