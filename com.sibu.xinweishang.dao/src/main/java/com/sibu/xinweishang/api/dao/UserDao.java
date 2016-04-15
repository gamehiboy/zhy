package com.sibu.xinweishang.api.dao;

import java.util.List;
import java.util.Map;

import com.sibu.xinweishang.api.model.User;

public interface UserDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
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
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);
	
	/**
	 * 得到一个用户信息
	 * @param id
	 * @return
	 */
	public User getUser(int id);
	
	/**
	 * 添加用户信息到指定的表中
	 * @param tablename
	 * @param user
	 * @return
	 */
	public int addTableUser(Map<String, String> param);
	
	/**
	 * 查询分布式数据中的数据
	 * @param param
	 * @return
	 */
	public User getTableUser(Map<String, String> param);
}
