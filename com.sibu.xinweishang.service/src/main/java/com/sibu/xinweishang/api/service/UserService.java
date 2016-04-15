package com.sibu.xinweishang.api.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibu.xinweishang.api.dao.UserDao;
import com.sibu.xinweishang.api.dao.UserMapper;
import com.sibu.xinweishang.api.model.User;
import com.sibu.xinweishang.common.data.Pager;
import com.sibu.xinweishang.common.database.DBContextHolder;
import com.sibu.xinweishang.common.strategy.DBPrimaryKeyCreate;
import com.sibu.xinweishang.common.strategy.DbUtil;


@Service("userService")
public class UserService implements IUserService {

	@Resource
	private UserDao userDao;
	@Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordHelper passwordHelper;

	public int addUser(User user) {
		return userDao.addUser(user);
	}
	
	public List<User> selectUsers() {
		return userDao.selectUsers();
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public int addTableUser(User user) {
		String userId = DBPrimaryKeyCreate.getUUID();
		String dataBase = DbUtil.GetDataBaseModValue(userId);
		String tableName = DbUtil.GetTableNameModValue(userId);
		System.out.println("插入用户在"+dataBase+"库，"+tableName+"表");
		DBContextHolder.setDBType(dataBase);
		Map<String, String> map = new HashMap<String, String>();  
        map.put("tablename", tableName);
        map.put("user_id", "'"+dataBase+tableName+userId+"'");
        map.put("state", "'"+user.getState()+"'");  
        map.put("nickname", "'"+user.getNickname()+"'");
		return userDao.addTableUser(map);
	}

	public User getTableUser(String userId) {
		String dataBase = DbUtil.GetDataBaseModValue(userId);
		String tableName = DbUtil.GetTableNameModValue(userId);
		DBContextHolder.setDBType(dataBase);
		Map<String, String> map = new HashMap<String, String>();
		map.put("tablename", tableName);
	    map.put("user_id", userId);
		return userDao.getTableUser(map);
	}

	public int deleteUser(String id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	/**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userMapper.insert(user);
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
    	userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
    	
        User user =userMapper.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findOne(Long userId) {
    	
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAll() {    	
        return userMapper.selectAll();
    }

    /**
     * 根据用户名查找用�?
     * @param username
     * @return
     */
    public User findByUsername(String username) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("userName", username);
    	User u = userMapper.selectByUsername(map);
        return u ;
    }

	/*@Override
	public List<User> findPage(Pager<User> p) {
		// TODO Auto-generated method stub
		return userMapper.selectPage(p);
	}*/
}
