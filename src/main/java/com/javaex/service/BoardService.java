package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;
@Service

public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getList2(@RequestParam String keyword) {
		System.out.println("BoardService.getList2()");
		
		List<BoardVo> boardList = boardDao.selectList2(keyword);
		System.out.println(boardList);
		
		return boardList;
	}
	
	public List<BoardVo> getList() {
		System.out.println("BoardService.getList()");
		
		boardDao.selectList();
		//Dao selectList()호출
		List<BoardVo> boardList = boardDao.selectList();
		System.out.println(boardList);
		
		return boardList;
		
	}
}
