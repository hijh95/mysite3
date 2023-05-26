package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;

public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	// 방명록폼 addList
	@RequestMapping(value = "/guestbook/addList",method= {RequestMethod.GET,RequestMethod.POST})
	public void addList() {
		System.out.println("GuestbookController.addList()");
	}
}


