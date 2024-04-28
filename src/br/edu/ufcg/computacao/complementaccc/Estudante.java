package br.edu.ufcg.computacao.complementaccc;

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
	 * Constrói o estudante.
	 * @param nome Nome do estudante.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param matricula Matrícula do estudante.
	 */
	public Estudante(String nome, String cpf, String senha, String matricula) {
		super(nome, cpf, senha);
		this.matricula = matricula;
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
	 * Representação textual do estudante.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Matrícula: " + matricula;
	}	
}