package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 회원가입폼
	@RequestMapping(value = "/user/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {

		System.out.println("UserController.joinForm()");
		return "/WEB-INF/views/user/joinForm.jsp";
	}

	// 회원가입
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {

		System.out.println("UserController.join()");

		int count = userService.join(userVo);
		// count= 0 ;
		System.out.println(count);
		if (count > 0) {
			return "/WEB-INF/views/user/joinOk.jsp";
		} else {
			return "redirect:/user/joinForm";
		}

		// return "/WEB-INF/views/user/joinOk.jsp";
	}

	// 로그인 폼
	@RequestMapping(value="/user/loginForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "/WEB-INF/views/user/loginForm.jsp";
	}

	// 로그인
	@RequestMapping(value="/user/login",method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");
		UserVo authUser = userService.login(userVo);
		System.out.println(authUser);
		if(authUser != null) {//로그인 성공했을 때
			System.out.println("로그인 성공");
			//세션에 저장
			session.setAttribute("authUser", authUser);
			//메인 리다이렉트
			return "redirect:/main";
		}else {//로그인 실패했을 때
			System.out.println("로그인 실패");
			//로그인 폼으로 보냄
			
		}
		
		return "";
	}
	
	/* 로그아웃 */
	@RequestMapping(value="/user/logout",method= {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpSession	session) {
		System.out.println("UserController.login()");
		session.removeAttribute("authUser");
		session.invalidate();//초기화
		return "redirect:/main";
	}
	
	/* 회원정보수정폼*/
	@RequestMapping(value="/user/modifyForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("UserController.modifyForm()");
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		int no =authUser.getNo();
		UserVo userVo = userService.modifyForm(no);
		model.addAttribute("userVo",userVo);
		System.out.println(userVo);
		return "/WEB-INF/views/user/modifyForm.jsp";
	}
	
	/* 회원정보 수정 */
	@RequestMapping(value="/user/modify",method= {RequestMethod.GET,RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.modify()");
		//userVo no가없음 <--세션에서 가져올 예정
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		int no= authUser.getNo();
		userVo.setNo(no);
		
		//서비스 넘긴다  db수정
		
		//세션에 있는 name 변경
		String name = userVo.getName();
		authUser.setName(name);
		userService.modify(userVo);
		return "redirect:/main";
	}
	
	
}
