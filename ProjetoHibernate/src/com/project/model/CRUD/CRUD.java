package com.project.model.CRUD;

import java.util.List;



public interface CRUD<Generico> {
	
	public List<Generico> listarTodos();
	
	public void inserir(Generico generico);
	
	public void deletar(Generico generico);
	
	public void alterar(Generico generico);

}
