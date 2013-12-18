package com.vh.controller.util;

import org.hibernate.Session;
import com.vh.model.dao.AlunosDao;



public class Repositorios {
	
	public AlunosDao getAlunos(){
		return new AlunosDao(this.getSession());
	}
	
	
	public Session getSession(){
		return (Session) FacesUtil.getRequestAttribute("session");
	}

}
