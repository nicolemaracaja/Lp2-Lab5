package br.edu.ufcg.computacao.complementaccc;

public class Admin extends Usuario{

	public Admin(String nome, String cpf, int senha) {
		super(nome, cpf, senha);	
	}

	public void reconfigurar(String novoNome, String novoCpf, int novaSenha) {
        this.nome = novoNome;
        this.cpf = novoCpf;
        this.senha = novaSenha;
    }
	
	@Override
	public String toString() {
		return super.toString();
	}		
}