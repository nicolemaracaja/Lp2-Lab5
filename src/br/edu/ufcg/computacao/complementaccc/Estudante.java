package br.edu.ufcg.computacao.complementaccc;

public class Estudante extends Usuario{

	protected String matricula;
	
	public Estudante(String nome, String cpf, int senha, String matricula) {
		super(nome, cpf, senha);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return this.matricula;
	}
	
	public void setMatricula(String novaMatricula) {
		this.matricula = novaMatricula;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Matrícula: " + matricula;
	}	
}