package com.getOpenId.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getOpenId.dao.GetopenidUserTMapper;
import com.getOpenId.model.GetopenidUserT;
import com.getOpenId.service.IUserService;

/** 
* @ClassName: UserServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Rex 
* @date 2016年5月28日 上午10:49:43 
*  
*/
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
    private GetopenidUserTMapper userDao;  
	
    public GetopenidUserT getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

}
