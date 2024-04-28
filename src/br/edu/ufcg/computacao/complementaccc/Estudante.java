package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe Estudante, que possui herança de Usuário.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Estudante extends Usuario{

	/**
	 * Matrícula do estudante.
	 */
	protected String matricula;
	
	/**
	 * Lista das atividades que o estudante participa.
	 */
	protected List<Atividade> atividades;
	
	/**
	 * Quantidade de atividades que o estudante participa.
	 */
	protected int atividadeCount;
	
	/**
	 * Constrói o estudante.
	 * @param nome Nome do estudante.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param matricula Matrícula do estudante.
	 */
	public Estudante(String nome, String cpf, String senha, String matricula) {
		super(nome, cpf, senha);
		this.matricula = matricula;
		this.atividades = new ArrayList<>();
		this.atividadeCount = 0;
	}

	/**
	 * Pega a matrícula do estudante.
	 * @return matricula Matrícula do estudante.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Altera a matrícula do estudante.
	 * @param novaMatricula Nova matrícula do estudante.
	 */
	public void setMatricula(String novaMatricula) {
		this.matricula = novaMatricula;
	}
	
	/**
	 * Adiciona uma nova atividade a lista de atividades do estudante.
	 * @param atividade Atividade.
	 */
	 public void adicionarAtividade(Atividade atividade) {
		 this.atividades.add(atividade);
	     this.atividadeCount++;
	 }
	 
	 /**
	  * Pega as atividades que o estudante participa.
	  * @return atividades Atividades do estudante.
	  */
	 public List<Atividade> getAtividades() {
	    return atividades;
	 }

	/**
	 * Representação textual do estudante.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Matrícula: " + matricula;
	}	
}