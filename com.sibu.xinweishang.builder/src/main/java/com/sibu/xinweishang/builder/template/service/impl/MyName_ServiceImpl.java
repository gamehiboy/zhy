package com.sibu.xinweishang.builder.template.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sibu.xinweishang.builder.template.bean.MyName_Bean;
import com.sibu.xinweishang.builder.template.dao.MyName_Dao;
import com.sibu.xinweishang.builder.template.service.MyName_Service;
import com.sibu.xinweishang.common.data.Pager;
import com.sibu.xinweishang.common.database.DBContextHolder;
import com.sibu.xinweishang.common.strategy.DbUtil;
import com.sibu.xinweishang.common.util.Object2MapUtil;

/**
 * MyName_ServiceImpl
 * @author 作者_
 **/
@Service("myName_Service")
public class MyName_ServiceImpl implements MyName_Service{

	@Resource
	private MyName_Dao myName_Dao;
	
	public MyName_Bean getBeanById(String id) throws Exception {
		return myName_Dao.getBeanById(id);
	}

	public MyName_Bean getBeanFromSub(String id, String memberId)
			throws Exception {
		String dataBase = DbUtil.GetDataBaseModValue(memberId);
		String tableName = DbUtil.GetTableNameModValue(memberId);
		DBContextHolder.setDBType(dataBase);//切换数据源
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tablename", tableName);
		parameters.put("id", id);
		return myName_Dao.getBeanByIdFromTable(parameters);
	}

	public List<MyName_Bean> list() throws Exception {
		return myName_Dao.list();
	}

	public List<MyName_Bean> listFromSub(Map<String, Object> params) throws Exception {
		return myName_Dao.listFromTable(params);
	}

	public Pager<MyName_Bean> find(Pager<MyName_Bean> pager) throws Exception {
		return myName_Dao.listPage(pager);
	}

	public Pager<MyName_Bean> findFromSub(Pager<MyName_Bean> pager,
			String memberId) throws Exception {
		String dataBase = DbUtil.GetDataBaseModValue(memberId);
		String tableName = DbUtil.GetTableNameModValue(memberId);
		DBContextHolder.setDBType(dataBase);//切换数据源
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tablename", tableName);
		parameters.put("page", pager.getPageOffset());
		parameters.put("pageSize", pager.getPageSize());
		pager.setDatas(this.listFromSub(parameters));
		pager.setTotalRecord(this.countFromSub(parameters));
		return pager;
	}
	
	public Pager<MyName_Bean> findByParams(Pager<MyName_Bean> pager,
			MyName_Bean bean, String memberId) throws Exception {
		String dataBase = DbUtil.GetDataBaseModValue(memberId);
		String tableName = DbUtil.GetTableNameModValue(memberId);
		DBContextHolder.setDBType(dataBase);//切换数据源
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tablename", tableName);
		parameters.put("page", pager.getPageOffset());
		parameters.put("pageSize", pager.getPageSize());
		parameters.putAll(Object2MapUtil.beanToMap(bean));
		pager.setDatas(this.listFromSub(parameters));
		pager.setTotalRecord(this.countFromSub(parameters));
		return pager;
	}
	
	public int add(MyName_Bean bean) throws Exception {
		return myName_Dao.add(bean);
	}

	public int addToSub(MyName_Bean bean, String memberId) throws Exception {
		String dataBase = DbUtil.GetDataBaseModValue(memberId);
		String tableName = DbUtil.GetTableNameModValue(memberId);
		DBContextHolder.setDBType(dataBase); //切换数据源
		Map<String, Object> beanMap = Object2MapUtil.beanToMap(bean);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tablename", tableName);
		parameters.putAll(beanMap);
		return myName_Dao.addBeanToTable(parameters);
	}

	public int delete(String id) throws Exception {
		return myName_Dao.deleteById(id);
	}

	public int deleteFromSub(String id, String memberId) throws Exception {
		String dataBase = DbUtil.GetDataBaseModValue(memberId);
		String tableName = DbUtil.GetTableNameModValue(memberId);
		DBContextHolder.setDBType(dataBase); //切换数据源
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tablename", tableName);
		parameters.put("id", id);
		return myName_Dao.deleteByIdFromTable(parameters);
	}

	public int update(MyName_Bean bean) throws Exception {
		return myName_Dao.update(bean);
	}

	public int updateFromSub(MyName_Bean bean, String memberId)
			throws Exception {
		String dataBase = DbUtil.GetDataBaseModValue(memberId);
		String tableName = DbUtil.GetTableNameModValue(memberId);
		DBContextHolder.setDBType(dataBase); //切换数据源
		Map<String, Object> beanMap = Object2MapUtil.beanToMap(bean);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tablename", tableName);
		parameters.putAll(beanMap);
		return myName_Dao.updateFromTable(parameters);
	}

	public int count() throws Exception {
		return myName_Dao.count();
	}

	public int countByParams(MyName_Bean bean) throws Exception {
		return myName_Dao.countByParams(bean);
	}

	public int countFromSub(Map<String, Object> parameters) throws Exception {
		return myName_Dao.countFromSub(parameters);
	}
}