package com.javaex.vo;

public class GuestbookVo {
	private int no;
	private String name;
	private String password;
	private String witdate;
	private String write;
	
	public GuestbookVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GuestbookVo(int no, String name, String password, String witdate, String write) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.witdate = witdate;
		this.write = write;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWitdate() {
		return witdate;
	}

	public void setWitdate(String witdate) {
		this.witdate = witdate;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", witdate=" + witdate
				+ ", write=" + write + "]";
	}
	
	
	
}
