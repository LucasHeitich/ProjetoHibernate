package com.project.controller.beans.cons;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.project.controller.util.Repositorios;
import com.project.model.DAO.AlunosDao;
import com.project.model.vo.Alunos;

@ManagedBean(name="consultaMB")
@SessionScoped
public class ConsultaMB {
	
	private List<Alunos> listaAlunos = new ArrayList<Alunos>();
	private ArrayList<Alunos> selecionados;
	private List<Alunos> alunoFiltrado;
	private List<Alunos> todosAlunos;
	private Alunos alunoAlterado;
	private AlunosDao alunosDao;
	private Repositorios repo;
	private String filtro;
	private boolean sorted;
	private boolean asc;
	private boolean itemSelecionado;
	
	@PostConstruct 
	public void initMB(){	
		repo = new Repositorios();
		alunosDao = repo.getAlunos();
		todosAlunos = alunosDao.listarTodos();
	
	}


	
	
	public void buscarFiltro(){
		this.alunoFiltrado = new ArrayList<Alunos>();
		
		for (int i = 0; i < this.todosAlunos.size(); i++) {
			if(this.todosAlunos.get(i).getNome().toLowerCase().contains(this.filtro.toLowerCase())					
					||Integer.toString(this.todosAlunos.get(i).getiAlunos()).equals(this.filtro)){
				this.alunoFiltrado.add(this.todosAlunos.get(i));	
			}
		}
	}
	
	
	
	public void alterarCadastro(Alunos item) {
		this.alunoAlterado = item;
	}
	public void alterar(){
		 HttpServletRequest request =  (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		this.alunosDao = repo.getAlunos();
		alunosDao.alterar(alunoAlterado);
		FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados alterados com sucesso!", ""));
		
	}
	
	public void excluir(Alunos aluno){ 
		
		this.repo = new Repositorios();
		this.alunosDao = repo.getAlunos();	
		this.alunosDao.deletar(aluno);
	
	}



	public boolean isSorted() {
	    return sorted;
    }



	public void setSorted(boolean sorted) {
	    this.sorted = sorted;
    }



	public boolean isAsc() {
	    return asc;
    }



	public void setAsc(boolean asc) {
	    this.asc = asc;
    }



	public boolean isItemSelecionado() {
	    return itemSelecionado;
    }



	public void setItemSelecionado(boolean itemSelecionado) {
	    this.itemSelecionado = itemSelecionado;
    }



	public List<Alunos> getListaAlunos() {
		return listaAlunos;
	}



	public void setListaAlunos(List<Alunos> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}



	public ArrayList<Alunos> getSelecionados() {
		return selecionados;
	}



	public void setSelecionados(ArrayList<Alunos> selecionados) {
		this.selecionados = selecionados;
	}



	public List<Alunos> getAlunoFiltrado() {
		return alunoFiltrado;
	}



	public void setAlunoFiltrado(List<Alunos> alunoFiltrado) {
		this.alunoFiltrado = alunoFiltrado;
	}



	public List<Alunos> getTodosAlunos() {
		repo = new Repositorios();
		alunosDao = repo.getAlunos();
		todosAlunos = alunosDao.listarTodos();
		return todosAlunos;
	}



	public void setTodosAlunos(List<Alunos> todosAlunos) {
		this.todosAlunos = todosAlunos;
	}







	public AlunosDao getAlunosDao() {
		return alunosDao;
	}



	public void setAlunosDao(AlunosDao alunosDao) {
		this.alunosDao = alunosDao;
	}



	public String getFiltro() {
		return filtro;
	}



	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}



	public Alunos getAlunoAlterado() {
	    return alunoAlterado;
    }



	public void setAlunoAlterado(Alunos alunoAlterado) {
	    this.alunoAlterado = alunoAlterado;
    }
	
	
}
