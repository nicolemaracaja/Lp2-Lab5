package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe Estudante, que possui herança de Usuário.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Estudante extends Usuario implements Comparable<Estudante>{

	/**
	 * Matrícula do estudante.
	 */
	protected String matricula;
	
	/**
	 * Mapa das atividades que o estudante participa.
	 */
	protected Map<String, Atividade> atividades;
	
	/**
	 * Quantidade de atividades que o estudante participa.
	 */
	protected int atividadeCount;
	
	/**
	 * Lista dos relatórios que o estudante participante.
	 */
	protected List<Relatorio> relatorios;
	
	/**
	 * Quantidade de relatórios que o estudante registrou.
	 */
	protected int relatorioCount;
	
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
		this.atividades = new HashMap<>();
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
	 public void adicionarAtividade(String codigoATV, Atividade atividade) {
		 this.atividades.put(codigoATV, atividade);
	     this.atividadeCount++;
	 }
	 
	 /**
	  * Pega as atividades que o estudante participa.
	  * @return atividades Atividades do estudante.
	  */
	 public Map<String, Atividade> getAtividades() {
	    return atividades;
	 }
	 
	 public void adicionarRelatorio(Relatorio relatorio) {
		 this.relatorios.add(relatorio);
		 this.relatorioCount++;
	 }

	/**
	 * Representação textual do estudante.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Matrícula: " + matricula;
	}	

	/**
	 * Comparador de estudantes.
	 */
	@Override
	public int compareTo(Estudante o) {
		return this.nome.compareTo(o.nome);
	}
}