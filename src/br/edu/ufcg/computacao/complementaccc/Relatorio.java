package br.edu.ufcg.computacao.complementaccc;

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
     * Constrói o relatório.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param matricula Matrícula do estudante.
     */
    public Relatorio(String nome, String cpf, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    /**
     * Representação textual do relatório.
     */
    @Override
    public abstract String toString();
}
