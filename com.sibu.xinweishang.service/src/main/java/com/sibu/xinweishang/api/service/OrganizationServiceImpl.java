package com.sibu.xinweishang.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibu.xinweishang.api.dao.OrganizationMapper;
import com.sibu.xinweishang.api.model.Organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @ClassName: OrganizationServiceImpl
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
   /* @Autowired
    private OrganizationDao organizationDao;*/
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public Organization createOrganization(Organization organization) {
    	organizationMapper.insertSelective(organization);
        return organization;
    }

    @Override
    public Organization updateOrganization(Organization organization) {
    	organizationMapper.updateByPrimaryKeySelective(organization);
        return organization;
    }

    @Override
    public void deleteOrganization(Long id) {
    	organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Organization findOne(Long organizationId) {
    	return organizationMapper.selectByPrimaryKey(organizationId);
    }

    @Override
    public List<Organization> findAll() {
    	return organizationMapper.selectAll();
    }

    @Override
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("id", excludeOraganization.getId());
    	map.put("parentIds",excludeOraganization.makeSelfAsParentIds());
    	
        return organizationMapper.selectAllWithExclude(map);
    }

    @Override
    public void move(Organization source, Organization target) {
    	Map<String,Object> mapOne=new HashMap<String,Object>();
    	mapOne.put("parentId", target.getId());
    	mapOne.put("parentIds", target.getParentIds());
    	mapOne.put("id",source.getId());
    	organizationMapper.moveStepOne(mapOne);
    	
    	Map<String,Object> mapTwo=new HashMap<String,Object>();
    	mapTwo.put("targetParentIds", target.makeSelfAsParentIds());
    	mapTwo.put("sourceParentIds", source.makeSelfAsParentIds());
    	organizationMapper.moveStepTwo(mapTwo);
    	
    }
}
