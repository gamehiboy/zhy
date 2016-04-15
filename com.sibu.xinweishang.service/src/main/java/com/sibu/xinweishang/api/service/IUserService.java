package com.sibu.xinweishang.api.service;


import java.util.List;

import com.sibu.xinweishang.api.model.User;
import com.sibu.xinweishang.common.data.Pager;


public interface IUserService {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 将用户信息添加到特定的表中
	 * @param tablename table为数据源的模值，如果是0为主库
	 * @param user
	 * @return
	 */
	public int addTableUser(User user);
	
	/**
	 * 查询用户列表
	 * @return
	 */
	public List<User> selectUsers();
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 
	* @Title: deleteUser 
	* @Description: 删除用户
	* @author xiaoheliu
	* @date 2016年3月9日 下午1:27:32
	* @param @param id
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int deleteUser(String id);
	
	/**
	 * 查询分布式库中的数据
	 * @param id
	 * @return
	 */
	
	public User getTableUser(String userId);
	
	/**
     * 创建用户
     * @param user
     */
    public User createUser(User user);

    public void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);


    User findOne(Long userId);

    List<User> findAll();
//    List<User> findPage(Pager<User> p);

    /**
     * 根据用户名查找用�?
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
