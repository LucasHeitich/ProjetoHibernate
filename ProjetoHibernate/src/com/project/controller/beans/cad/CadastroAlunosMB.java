package com.project.controller.beans.cad;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.project.controller.util.Repositorios;
import com.project.model.DAO.AlunosDao;
import com.project.model.vo.Alunos;

@ManagedBean(name="cadastro")
public class CadastroAlunosMB {

	private Repositorios repo = new Repositorios();
	private Alunos alunos;
	
	
	private AlunosDao alunosDao;
	
	
	@PostConstruct
	public void inicializar(){
		alunos = new Alunos();
	}

	public void teste(){
		System.out.println("arroz");
	}
	public String goToBegin(){
		return "Inicio?faces-redirect=true";
	}
	public void cadastrar(){
		alunosDao = repo.getAlunos();
		
		
		try {		
			alunos.setSituacaoAluno(true);
			alunosDao.inserir(this.alunos);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!", ""));
			alunos = new Alunos();
			
		
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar cadastrar!", ""));
			
		}
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	
}
