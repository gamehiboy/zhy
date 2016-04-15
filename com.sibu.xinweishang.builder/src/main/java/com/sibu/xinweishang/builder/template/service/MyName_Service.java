package com.sibu.xinweishang.builder.template.service;


import java.util.List;
import java.util.Map;

import com.sibu.xinweishang.builder.template.bean.MyName_Bean;
import com.sibu.xinweishang.common.data.Pager;


/**
 * MyName_Service
 * @author 作者_
**/
public interface MyName_Service {
	
	/**
	 * 
	* @Title: getBeanById 
	* @Description: 查询主库中的数据【主库】
	* @author 
	* @date 2016年3月9日 下午1:36:21
	* @param @param id 记录id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return MyName_Bean    返回类型 
	* @throws
	 */
	public MyName_Bean getBeanById(String id) throws Exception;
	/**
	 * 
	* @Title: getBeanFromSub 
	* @Description: 查询分库中的数据【分库】
	* @author 
	* @date 2016年3月9日 下午1:36:47
	* @param @param id 记录id
	* @param @param memberId 用户表的id
	* @param @throws Exception    设定文件 
	* @return MyName_Bean    返回类型 
	* @throws
	 */
	public MyName_Bean getBeanFromSub(String id, String memberId) throws Exception;
	
	/**
	 * 
	* @Title: listPager 
	* @Description: 获取所有数据【主库】
	* @author 
	* @date 2016年3月9日 下午1:50:33
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<MyName_Bean>    返回类型 
	* @throws
	 */
	public List<MyName_Bean> list() throws Exception;
	
	/**
	 * 
	* @Title: listPagerFromSub 
	* @Description: 获取所有数据【分库】
	* @author 
	* @date 2016年3月9日 下午1:51:02
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<MyName_Bean>    返回类型 
	* @throws
	 */
	public List<MyName_Bean> listFromSub(Map<String, Object> params) throws Exception;
	
	/**
	 * 
	* @Title: find 
	* @Description: 分页数据【主库】
	* @author 
	* @date 2016年3月9日 下午1:55:35
	* @param @param pager
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Pager<MyName_Bean>    返回类型 
	* @throws
	 */
	public Pager<MyName_Bean> find(Pager<MyName_Bean> pager) throws Exception;
	
	/**
	 * 
	* @Title: findFromSub 
	* @Description: 分页数据，无查询条件【分库】
	* @author 
	* @date 2016年3月9日 下午1:56:18
	* @param @param pager
	* @param @param memberId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Pager<MyName_Bean>    返回类型 
	* @throws
	 */
	public Pager<MyName_Bean> findFromSub(Pager<MyName_Bean> pager, String memberId) throws Exception;
	
	/**
	 * 
	* @Title: findByParams 
	* @Description: 分页数据，有查询条件
	* @author 
	* @date 2016年3月9日 下午2:42:31
	* @param @param pager
	* @param @param bean
	* @param @param memberId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Pager<MyName_Bean>    返回类型 
	* @throws
	 */
	public Pager<MyName_Bean> findByParams(Pager<MyName_Bean> pager, MyName_Bean bean, String memberId) throws Exception;
	
	/**
	 * 
	* @Title: add 
	* @Description: 添加数据到【主库】
	* @author 
	* @date 2016年3月9日 下午1:58:14
	* @param @param bean
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int add(MyName_Bean bean) throws Exception;
	
	/**
	 * 
	* @Title: addToSub 
	* @Description: 添加数据【分库】
	* @author 
	* @date 2016年3月9日 下午1:58:32
	* @param @param bean
	* @param @param member
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int addToSub(MyName_Bean bean, String memberId) throws Exception;
	
	/**
	 * 
	* @Title: delete 
	* @Description: 删除数据【主库】
	* @author 
	* @date 2016年3月9日 下午2:00:08
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int delete(String id) throws Exception;
	
	/**
	 * 
	* @Title: deleteFromSub 
	* @Description: 删除数据【分库】
	* @author 
	* @date 2016年3月9日 下午2:00:29
	* @param @param id
	* @param @param memberId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int deleteFromSub(String id, String memberId) throws Exception;
	
	/**
	 * 
	* @Title: update 
	* @Description: 更新数据【主库】
	* @author 
	* @date 2016年3月9日 下午2:02:02
	* @param @param bean
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int update(MyName_Bean bean) throws Exception;
	/**
	 * 
	* @Title: updateFromSub 
	* @Description: 更新数据【分库】
	* @author 
	* @date 2016年3月9日 下午2:02:22
	* @param @param bean
	* @param @param memberId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int updateFromSub(MyName_Bean bean, String memberId) throws Exception;
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