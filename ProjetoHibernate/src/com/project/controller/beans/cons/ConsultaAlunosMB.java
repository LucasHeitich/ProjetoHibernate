package com.project.controller.beans.cons;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import com.project.controller.util.Repositorios;
import com.project.model.DAO.AlunosDao;
import com.project.model.vo.Alunos;

@ManagedBean(name="consultaMB")
@SessionScoped
public class ConsultaAlunosMB {
	

	private ArrayList<Alunos> selecionados;
	private List<Alunos> alunoFiltrado;
	private List<Alunos> todosAlunos;
	private Alunos alunoAlterado;
	private AlunosDao alunosDao;
	private Repositorios repo;
	private String filtro;
	
	private HttpServletRequest req;
	private static final String TODOS_ALUNOS_SESSION = "todosAlunosSession";
	
	@SuppressWarnings("unchecked")
    @PostConstruct 
	public void initMB(){	
		req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if (todosAlunos == null && req.getSession().getAttribute(TODOS_ALUNOS_SESSION) == null){
			
			repo = new Repositorios();
			alunosDao = repo.getAlunos();
			todosAlunos = alunosDao.listarTodos();
			req.getSession().setAttribute(TODOS_ALUNOS_SESSION, todosAlunos);
			
		}else{
			todosAlunos =  req.getSession().getAttribute(TODOS_ALUNOS_SESSION) == null ? todosAlunos : (List<Alunos>)req.getSession().getAttribute(TODOS_ALUNOS_SESSION) ;
		}
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
		
		
		this.alunosDao = repo.getAlunos();
		alunosDao.alterar(alunoAlterado);
		FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados alterados com sucesso!", ""));
		
	}
	
	public void excluir(Alunos aluno){ 
		
		this.repo = new Repositorios();
		this.alunosDao = repo.getAlunos();	
		this.alunosDao.deletar(aluno);
		this.todosAlunos.remove(aluno);
	
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
		return todosAlunos;
	}



	public void setTodosAlunos(List<Alunos> todosAlunos) {
		this.todosAlunos = todosAlunos;
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
