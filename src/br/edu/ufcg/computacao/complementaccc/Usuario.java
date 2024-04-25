package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;

public class Usuario{

	protected String nome;
	protected String cpf;
	protected int senha;
	
	public Usuario(String nome, String cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) { //para alterar o admin
		this.nome = novoNome;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public int getSenha() {
		return this.senha;
	}
	
	public void setSenha(int novaSenha) { //tanto admin quanto estudante 
		this.senha = novaSenha;
	}

	public boolean autenticar(int senha) {
		return this.senha == senha;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

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

	public String toString() {
		return "Usuário\n" + "Nome: " + nome + "\n" + "CPF: ";
	}	
}