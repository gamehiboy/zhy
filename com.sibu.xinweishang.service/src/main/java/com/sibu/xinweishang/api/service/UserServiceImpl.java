package com.sibu.xinweishang.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibu.xinweishang.api.dao.UserMapper;
import com.sibu.xinweishang.api.model.User;

import java.util.*;

/**
* @ClassName: UserServiceImpl
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月13日
*
 */
@Service
public class UserServiceImpl implements IUserService {

   /* @Autowired
    private UserDao userDao;*/
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private RoleService roleService;

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

    /*public User updateUser(User user) {
    	userMapper.updateByPrimaryKeySelective(user);
        return user;
    }*/

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

    public User findOne(Long userId) {
    	
        return userMapper.selectByPrimaryKey(userId);
    }

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

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addTableUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getTableUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public List<User> findPage(Page<User> p) {
		// TODO Auto-generated method stub
		return userMapper.selectPage(p);
	}*/


}
