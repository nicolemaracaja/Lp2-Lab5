package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Admin, que possui herança de Usuário.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Admin extends Usuario{

	/**
	 * Constrói o Admin.
	 * @param nome Nome do admin.
	 * @param cpf CPF do admin.
	 * @param senha Senha do admin.
	 */
	public Admin(String nome, String cpf, String senha) {
		super(nome, cpf, senha);	
	}

	/**
	 * Reconfigura o administrador.
	 * @param novoNome Nome do novo admin.
	 * @param novoCpf CPF do novo admin.
	 * @param novaSenha Senha do novo admin.
	 */
	public void reconfigurar(String novoNome, String novoCpf, String novaSenha) {
        this.nome = novoNome;
        this.cpf = novoCpf;
        this.senha = novaSenha;
    }
	
	/**
	 * Representação textual do admin.
	 */
	@Override
	public String toString() {
		return super.toString();
	}		
}