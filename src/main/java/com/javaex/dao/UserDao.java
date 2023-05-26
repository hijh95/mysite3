package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	// 회원등록
	public int insertUser(UserVo userVo) {
		System.out.println("UserDao.insertUser()");
		System.out.println(userVo);

		int count = sqlSession.insert("user.insert", userVo);

		return count;
	}

	/* 로그인 -->세선저장용 */
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao.selectUser");

		System.out.println(userVo);

		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		System.out.println(authUser);
		// return sqlSession.selectOne("user.selectUser",userVo);
		return authUser;

	}

	/* 회원정보 수정폼 회원정보 1명가져오기 */
	public UserVo selectUser(int no) {// 같은 메서드 =>오버로딩
		System.out.println("UserDao.modifyForm");
		System.out.println(no);
		UserVo userVo = sqlSession.selectOne("user.selectUserByNo", no);
		return userVo;
	}

	public void updateUser(UserVo userVo) {
		System.out.println("UserDao.modify()");
		System.out.println(userVo);

		int count = sqlSession.update("user.update", userVo);
		System.out.println(count);

	}
}
