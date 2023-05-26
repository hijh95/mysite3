package com.javaex.vo;

public class BoardVo {
	private int no;
	private String title;
	private String writer;
	private int viewcnt;
	private String witdate;
	private String setting;
	
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BoardVo(int no, String title, String writer, int viewcnt, String witdate, String setting) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.viewcnt = viewcnt;
		this.witdate = witdate;
		this.setting = setting;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getWitdate() {
		return witdate;
	}

	public void setWitdate(String witdate) {
		this.witdate = witdate;
	}

	public String getSetting() {
		return setting;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}



	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", writer=" + writer + ", viewcnt=" + viewcnt + ", witdate="
				+ witdate + ", setting=" + setting + "]";
	}
	
	

	
}
