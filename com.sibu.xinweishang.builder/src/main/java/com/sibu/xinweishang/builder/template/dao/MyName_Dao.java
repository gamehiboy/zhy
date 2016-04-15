package com.sibu.xinweishang.builder.template.dao;


import java.util.List;
import java.util.Map;

import com.sibu.xinweishang.builder.template.bean.MyName_Bean;
import com.sibu.xinweishang.common.data.Pager;


public interface MyName_Dao {
	/**
	 * 
	* @Title: add 
	* @Description: 插入主库数据
	* @author 
	* @date 2016年3月8日 下午3:08:08
	* @param @param bean
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int add(MyName_Bean bean);
	
	/**
	 * 
	* @Title: addBeanToTable 
	* @Description: 将数据插入分库中
	* @author 
	* @date 2016年3月8日 下午3:15:01
	* @param @param parameters
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int addBeanToTable(Map<String, Object> parameters);
	
	/**
	 * 
	* @Title: update 
	* @Description: 更新对象
	* @author 
	* @date 2016年3月8日 下午3:09:58
	* @param @param bean
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int update(MyName_Bean bean);
	
	/**
	 * 
	* @Title: updateFromTable 
	* @Description: 在分库中更新数据
	* @author 
	* @date 2016年3月8日 下午3:37:08
	* @param @param parameters
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int updateFromTable(Map<String, Object> parameters);
	
	/**
	 * 
	* @Title: deleteById 
	* @Description: 删除数据
	* @author 
	* @date 2016年3月8日 下午3:10:16
	* @param @param id
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int deleteById(String id);
	
	/**
	 * 
	* @Title: deleteByIdFromTable 
	* @Description: 从分库中删除数据
	* @author 
	* @date 2016年3月8日 下午3:36:24
	* @param @param parameters
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int deleteByIdFromTable(Map<String, Object> parameters);
	
	/**
	 * 
	* @Title: getBeanById 
	* @Description: 获取数据根据ID
	* @author 
	* @date 2016年3月8日 下午3:10:58
	* @param @param id
	* @param @return    设定文件 
	* @return MyName_Bean    返回类型 
	* @throws
	 */
	public MyName_Bean getBeanById(String id);
	
	/**
	 * 
	* @Title: getBeanByIdFromTable 
	* @Description: 从从库中查询数据 
	* @author 
	* @date 2016年3月8日 下午3:32:43
	* @param @param parameters
	* @param @return    设定文件 
	* @return MyName_Bean    返回类型 
	* @throws
	 */
	public MyName_Bean getBeanByIdFromTable(Map<String, Object> parameters);
	
	/**
	 * 
	* @Title: list 
	* @Description: 获取集合list
	* @author 
	* @date 2016年3月8日 下午3:08:34
	* @param @return    设定文件 
	* @return List<MyName_Bean>    返回类型 
	* @throws
	 */
	public List<MyName_Bean> list();
	
	/**
	 * 
	* @Title: listFromTable 
	* @Description: 查询数据
	* @author 
	* @date 2016年3月8日 下午3:30:33
	* @param @return    设定文件 
	* @return List<MyName_Bean>    返回类型 
	* @throws
	 */
	public List<MyName_Bean> listFromTable(Map<String, Object> parameters);
	
	/**
	 * 
	* @Title: listPage 
	* @Description: 从主库中查询分页
	* @author 
	* @date 2016年3月8日 下午3:30:11
	* @param @param pager
	* @param @return    设定文件 
	* @return Pager<MyName_Bean>    返回类型 
	* @throws
	 */
	public Pager<MyName_Bean> listPage(Pager<MyName_Bean> pager);
	
	/**
	 * 
	* @Title: listPageFromTable 
	* @Description: 从分库中查询数据分页
	* @author 
	* @date 2016年3月8日 下午3:29:53
	* @param @param parameters
	* @param @return    设定文件 
	* @return Pager<MyName_Bean>    返回类型 
	* @throws
	 */
	public Pager<MyName_Bean> listPageFromTable(Map<String, Object> parameters);
	
	/**
	 * 
	* @Title: count 
	* @Description: 统计无参数【主库】
	* @author 
	* @date 2016年3月9日 下午2:39:27
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int count() throws Exception;
	/**
	 * 
	* @Title: count 
	* @Description: 统计有参数【主库】
	* @author 
	* @date 2016年3月9日 下午2:39:40
	* @param @param bean
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int countByParams(MyName_Bean bean) throws Exception;
	/**
	 * 
	* @Title: countFromSub 
	* @Description: 统计【分库】
	* @author 
	* @date 2016年3月9日 下午2:40:03
	* @param @param parameters
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int countFromSub(Map<String, Object> parameters) throws Exception;
}
