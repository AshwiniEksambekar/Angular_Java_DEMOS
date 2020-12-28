package com.app.sellerconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.sellerconsumer.DTO.UserDTO;
import com.app.sellerconsumer.dao.UserDao;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public UserDTO updateUserRole(UserDTO dto) {
		// Instead of making changes from db update and fetch temporary have return
		// results by toggle role value
		if (dto.getRole().equals("SELLER")) {
			dto.setRole("CONSUMER");
		} else {
			dto.setRole("SELLER");
		}
		// User user=null;
		// userDao.updateUserInfo(user);
		return dto;
	}

}
