package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public abstract class Relatorio {

	/**
	 * Nome do estudante.
	 */
	protected String nome;
	
	/**
	 * CPF do estudante.
	 */
	protected String cpf;
	
	/**
	 * Matrícula do estudante.
	 */
	protected String matricula;
	
	/**
	 * Lista de atividades no relatório.
	 */
	protected List<Atividade> atividadesRelatorio;
	

    /**
     * Constrói o relatório.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param matricula Matrícula do estudante.
     */
	public Relatorio(String nome, String cpf, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.atividadesRelatorio = new ArrayList<>();
    }

	public void adicionarAtividade(Atividade atividade) {
        this.atividadesRelatorio.add(atividade); // Adiciona atividade ao relatório
    }

    public List<Atividade> getAtividadesRelatorio() {
        return this.atividadesRelatorio; // Retorna a lista de atividades
    }

    /**
     * Método abstrato para exibir o relatório.
     */
    @Override
    public abstract String toString(); 
    
}
