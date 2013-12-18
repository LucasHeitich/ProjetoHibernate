package com.vh.model.vo;

import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="aluno")
public class Alunos {

	private String nome;
	private Date dataNascimento;
	private Integer iAlunos;
	private boolean situacaoAluno;

	
	@NotNull
	@Column(name="NomeAluno")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="DataNascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Id
	@GeneratedValue
	@Column(name="idAluno")
	public Integer getiAlunos() {
	    return iAlunos;
    }
	public void setiAlunos(Integer iAlunos) {
	    this.iAlunos = iAlunos;
    }
	public boolean isSituacaoAluno() {
	    return situacaoAluno;
    }
	public void setSituacaoAluno(boolean situacaoAluno) {
	    this.situacaoAluno = situacaoAluno;
    }
	
}
