package com.env.agile.model;

public class Greetings {
	 
   
	private String msg;
    private String name;
    public Greetings() {
		// TODO Auto-generated constructor stub
	}
    
    public Greetings(String msg, String name) {
		super();
		this.msg = msg;
		this.name = name;
	}
    
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
    
    
 
    // standard getters, setters and constructor
}
