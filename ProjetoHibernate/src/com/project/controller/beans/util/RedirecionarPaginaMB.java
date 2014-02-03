
package com.project.controller.beans.util;


import javax.faces.bean.ManagedBean;

@ManagedBean(name="redirecionarPaginaBean")
public class RedirecionarPaginaMB {
	
	private String local;

	public String redirecionar(){
		return local+"?faces-redirect=true";
		
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
