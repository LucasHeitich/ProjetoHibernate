package com.project.controller.beans;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="layoutBean")
public class LayoutMB {

	private Calendar c = Calendar.getInstance();
	private String data;
	
	public Calendar getC() {
		return c;
	}

	public void setC(Calendar c) {
		this.c = c;
	}

	public String getData() {
		this.data = Integer.toString((c.get(Calendar.YEAR)));
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
