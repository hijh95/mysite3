package com.javaex.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	
	//회원등록
	public int join(UserVo userVo) {
		System.out.println("UserService.join");
		
		int count = userDao.insertUser(userVo);
		return count;
	}
	

	/* 로그인 */
	public UserVo login(UserVo userVo) {
			System.out.println("UserService.login");
			UserVo authUser = userDao.selectUser(userVo);
			return authUser;
	}
	
	
	/*
	 * //로그인 폼 public void login(UserVo userVo) {
	 * System.out.println("UserService.login");
	 * 
	 * 
	 * }
	 */
	
	/* 회원정보수정폼 */
	public UserVo modifyForm(int no) {
		System.out.println("UserService.modifyForm");

		UserVo userVo = userDao.selectUser(no);
		return userVo;
	}
	
	
}
