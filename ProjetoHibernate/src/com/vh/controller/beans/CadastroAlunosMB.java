package com.vh.controller.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import com.vh.controller.util.Repositorios;
import com.vh.model.dao.AlunosDao;
import com.vh.model.vo.Alunos;

@ManagedBean(name="cadastro")
public class CadastroAlunosMB {

	private Repositorios repo = new Repositorios();
	private Alunos alunos;
	
	
	private AlunosDao alunosDao;
	
	
	@PostConstruct
	public void inicializar(){
		alunos = new Alunos();
	}

	public String goToBegin(){
		return "Inicio?faces-redirect=true";
	}
	public void cadastrar(){
		alunosDao = repo.getAlunos();
		System.out.println(alunosDao.listarTodos().get(0));
		
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
