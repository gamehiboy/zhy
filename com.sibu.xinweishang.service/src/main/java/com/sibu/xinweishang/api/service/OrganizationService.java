package com.sibu.xinweishang.api.service;


import java.util.List;

import com.sibu.xinweishang.api.model.Organization;

/**
* @ClassName: OrganizationService
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
public interface OrganizationService {


    public Organization createOrganization(Organization organization);
    public Organization updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
