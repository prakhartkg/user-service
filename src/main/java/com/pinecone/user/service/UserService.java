package com.pinecone.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pincone.serviceclients.DepartmentClient;
import com.pinecone.user.entity.User;
import com.pinecone.user.repository.UserRepository;
import com.pinecone.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	DepartmentClient departmentClient;
	
	
	public User createUser(User user) {
		log.info("createUser called with user {}",user);
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserByUserId(Long userId) {
		log.info("getUserByUserId called with userId {}",userId);
		ResponseTemplateVO res = new ResponseTemplateVO();
		User user = userRepository.findUserByUserId(userId);
		if(user!=null) {			
			res.setUser(user);
			res.setDepartment(departmentClient.getDepartmentById(user.getUserId()));
		}
		return res;
	}
}
