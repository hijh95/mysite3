package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="board/list2",method= {RequestMethod.GET,RequestMethod.POST})
	public String list2(String keyword) {
		System.out.println("BoardController.list2()");
	
		
		List<BoardVo> boardList = boardService.getList2(keyword);
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
	
	@RequestMapping(value="board/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(@RequestParam(value="keyword", required = false,defaultValue = "") String keyword, Model model) {
		System.out.println("BoardController.List()");
		System.out.println(keyword);
		
		List<BoardVo> boardList = boardService.getList2(keyword);
		System.out.println(boardList);
		
		model.addAttribute("boardList",boardList);
		return "/WEB-INF/views/board/list.jsp";
	}
	
}
