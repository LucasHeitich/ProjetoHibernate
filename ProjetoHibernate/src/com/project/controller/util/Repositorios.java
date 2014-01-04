package com.project.controller.util;

import org.hibernate.Session;

import com.project.model.DAO.AlunosDao;



public class Repositorios {
	
	public AlunosDao getAlunos(){
		return new AlunosDao(this.getSession());
	}
	
	
	public Session getSession(){
		return (Session) FacesUtil.getRequestAttribute("session");
	}

}
