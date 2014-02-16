package com.project.controller.beans.cons;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.project.controller.util.Repositorios;
import com.project.model.DAO.AlunosDao;
import com.project.model.vo.Alunos;
@ManagedBean(name="autoCompleteMB")
public class AutoCompleteMB {
	
	private ArrayList<Alunos> selecionado;
	private List<Alunos> todosAlunos;
	private HttpServletRequest req;
	private static final String TODOS_ALUNOS_SESSION = "todosAlunosSession";
	
	 @SuppressWarnings("unchecked")
     @PostConstruct 
		public void initMB(){	
			req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			if (todosAlunos == null && req.getSession().getAttribute(TODOS_ALUNOS_SESSION) == null){
				
				Repositorios repo;
				AlunosDao alunosDao;
				
				repo = new Repositorios();
				alunosDao = repo.getAlunos();
				todosAlunos = alunosDao.listarTodos();
				req.getSession().setAttribute(TODOS_ALUNOS_SESSION, todosAlunos);
				
			}else{
				todosAlunos =  req.getSession().getAttribute(TODOS_ALUNOS_SESSION) == null ? todosAlunos : (List<Alunos>)req.getSession().getAttribute(TODOS_ALUNOS_SESSION) ;
			}
		}
	 
	public List<Alunos> complete(String email){
		List<Alunos> sugestao = new ArrayList<Alunos>();
		for (Alunos aluno: todosAlunos) {
	        if (aluno.getNome().startsWith(email)){
	        	sugestao.add(aluno);
	        	
	        }
        }
		return sugestao;
	}
	public ArrayList<Alunos> getSelecionado() {
	    return selecionado;
    }
	public void setSelecionado(ArrayList<Alunos> selecionado) {
	    this.selecionado = selecionado;
    }
	

}
