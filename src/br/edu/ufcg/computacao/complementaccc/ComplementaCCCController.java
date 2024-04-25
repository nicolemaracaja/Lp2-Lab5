package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe controller que implementa as funções do sistema.
 */
public class ComplementaCCCController {

	private UsuarioController uc;
	
	public ComplementaCCCController() {
		this.uc = new UsuarioController();
	}
	
	/**
     * Cria um estudante com base em seu nome, seu cpf, sua senha e sua matrícula.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param matricula Matrícula do estudante.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
    public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
        return uc.criarEstudante(nome, cpf, senha, matricula);
    }

    /**
     * Exibe todos os estudantes se autenticado com admin.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return Array de strings com informações dos estudantes, ou null se a autenticação falhar.
     */
    public String[] exibirEstudantes(String cpfAdmin, int senhaAdmin) {
        return uc.exibirEstudantes(cpfAdmin, senhaAdmin);
    }

    /**
     * Altera dados de um estudante.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param tipoAlteracao Tipo de alteração ("nome", "matricula", "senha").
     * @param novoValor Novo valor para a alteração.
     * @return true se a alteração foi bem-sucedida, se não, false.
     */
    public boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
        return uc.alterarEstudante(cpf, senha, tipoAlteracao, novoValor);
    }

    /**
     * Exibe informações do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return String com informações do admin, ou null se a autenticação falhar.
     */
    public String exibirAdmin(String cpfAdmin, int senhaAdmin) {
        return uc.exibirAdmin(cpfAdmin, senhaAdmin);
    }

    /**
     * Configura ou reconfigura o admin com autenticação.
     * @param cpfAdmin CPF do admin.
     * @param senhaAtual Senha atual do admin.
     * @param nomeNovo Novo nome do admin.
     * @param cpfNovo Novo CPF do admin.
     * @param senhaNova Nova senha do admin.
     * @return true se a configuração foi bem sucedida, se não, false.
     */
    public boolean configurarNovoADMIN(String cpfAdmin, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova) {
        return uc.configurarNovoADMIN(cpfAdmin, senhaAtual, nomeNovo, cpfNovo, senhaNova);
    }

    /**
     * Altera a senha do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAtual Senha atual do admin.
     * @param senhaNova Nova senha do admin.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
    public boolean configurarSenhaADMIN(String cpfAdmin, int senhaAtual, int senhaNova) {
        return uc.configurarSenhaADMIN(cpfAdmin, senhaAtual, senhaNova);
    }

}
