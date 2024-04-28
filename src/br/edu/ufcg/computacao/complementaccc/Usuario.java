package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;

/**
 * Classe Usuário.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Usuario{

	/**
	 * Nome do usuário.
	 */
	protected String nome;
	
	/**
	 * CPF do usuário.
	 */
	protected String cpf;
	
	/**
	 * Senha do usuário.
	 */
	protected String senha;
	
	/**
	 * Constrói o usuário.
	 * @param nome Nome do usuário.
	 * @param cpf CPF do usuário.
	 * @param senha Senha do usuário.
	 */
	public Usuario(String nome, String cpf, String senha) throws IllegalArgumentException{
		if (nome.isBlank()) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}
		if (cpf.isBlank()) {
			throw new IllegalArgumentException("CPF INVÁLIDO!");
		}
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	/**
	 * Pega o nome do usuário.
	 * @return nome Nome do usuário.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Altera o nome do usuário.
	 * @param novoNome Novo nome do usuário.
	 */
	public void setNome(String novoNome) { //para alterar o admin
		this.nome = novoNome;
	}
	
	/**
	 * Pega o CPF do usuário.
	 * @return cpf CPF do usuário.
	 */
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * Pega a senha do usuário.
	 * @return senha Senha do usuário.
	 */
	public String getSenha() {
		return this.senha;
	}
	
	/**
	 * Altera a senha do usuário.
	 * @param novaSenha Nova senha do usuário.
	 */
	public void setSenha(String novaSenha) { //tanto admin quanto estudante 
		this.senha = novaSenha;
	}

	/**
	 * Autentica a permissão do usuário(admin) para realizar alterações no sistema.
	 * @param senha Senha do usuário.
	 * @return True, se a senha for a mesma, se não, false.
	 */
	public boolean autenticar(String senha) {
		return this.senha == senha;
	}
	
	/**
	 * HashCode, que retorna o hash de um objeto.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	/**
	 * Equals, para verificar a igualdade entre dois objetos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	/**
	 * Representação textual do usuário.
	 */
	public String toString() {
		return "Nome: " + this.nome + "\n" + "CPF: " + this.cpf;
	}	
}