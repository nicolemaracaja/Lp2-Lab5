package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public abstract class Relatorio {

	/**
	 * UsuarioController.
	 */
	protected UsuarioController uc;
	
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
    public Relatorio(UsuarioController uc, String nome, String cpf, String matricula) {
    	this.uc = uc;
    	Estudante estudante = uc.getEstudantes().get(cpf);
        this.nome = estudante.getNome();
        this.cpf = estudante.getCpf();
        this.matricula = estudante.getMatricula();
    }

    /**
     * Representação textual do relatório.
     */
    @Override
    public abstract String toString();
}
