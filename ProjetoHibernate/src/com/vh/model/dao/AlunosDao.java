package com.vh.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.vh.model.CRUD.CRUD;
import com.vh.model.vo.Alunos;

public class AlunosDao implements CRUD<Alunos> {
	private Session session;
	
	public AlunosDao(Session session){
		this.session = session;
	}
	
	@Override
	public List<Alunos> listarTodos() {
		
		return session.createCriteria(Alunos.class).list();
	}
	
	public Alunos getById(Integer id){
		return (Alunos) session.get(Alunos.class,id);		
	}

	@Override
	public void inserir(Alunos alunos) {
		this.session.persist(alunos);
		
	}

	@Override
	public void deletar(Alunos alunos) {
		this.session.delete(alunos);
		
	}

	@Override
	public void alterar(Alunos alunos) {
		this.session.merge(alunos);
		
	}

}
