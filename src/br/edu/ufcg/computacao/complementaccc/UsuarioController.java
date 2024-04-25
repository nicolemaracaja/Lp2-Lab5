package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

public class UsuarioController {

	private List<Estudante> estudantes;
	private Admin admin;
	
	public UsuarioController() {
		this.estudantes = new ArrayList<>();
		this.admin = new Admin("admin", "00000000000", 00000000);
	}
			
	public Admin getAdmin() {
		return admin;
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
        for (Estudante estudante : estudantes) {
            if (estudante.cpf.equals(cpf)) {
                return false; // CPF já cadastrado
            }
        }
        estudantes.add(new Estudante(nome, cpf, senha, matricula));
        return true;
    }

	 /**
     * Exibe todos os estudantes se autenticado com admin.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return Array de strings com informações dos estudantes, ou null se a autenticação falhar.
     */
    public String[] exibirEstudantes(String cpfAdmin, int senhaAdmin) {
        if (!admin.cpf.equals(cpfAdmin) && !admin.autenticar(senhaAdmin)) {
            return null; // Não autenticado
        }

        Collections.sort(estudantes, (e1, e2) -> e1.nome.compareTo(e2.nome)); // Ordenar por nome
        String[] resultado = new String[estudantes.size()];
        for (int i = 0; i < estudantes.size(); i++) {
            resultado[i] = estudantes.get(i).toString();
        }
        return resultado;
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
        for (Estudante estudante : estudantes) {
            if (estudante.cpf.equals(cpf) && estudante.autenticar(senha)) {
                switch (tipoAlteracao.toLowerCase()) {
                    case "nome":
                        estudante.setNome(novoValor);
                        return true;
                    case "matricula":
                        estudante.setMatricula(novoValor);
                        return true;
                    case "senha":
                        estudante.setSenha(Integer.parseInt(novoValor));
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false; // Estudante não encontrado ou senha incorreta
    }

    /**
     * Exibe informações do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return String com informações do admin, ou null se a autenticação falhar.
     */
    public String exibirAdmin(String cpfAdmin, int senhaAdmin) {
        if (admin == null || !admin.cpf.equals(cpfAdmin) || !admin.autenticar(senhaAdmin)) {
            return null; // Não autenticado
        }
        return admin.toString();
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
        if ((admin.cpf.equals(cpfAdmin) && admin.autenticar(senhaAtual))) {
            admin = new Admin(nomeNovo, cpfNovo, senhaNova); // Configurar ou reconfigurar ADMIN
            return true;
        }
        return false; // Não autenticado
    }

    /**
     * Altera a senha do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAtual Senha atual do admin.
     * @param senhaNova Nova senha do admin.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
    public boolean configurarSenhaADMIN(String cpfAdmin, int senhaAtual, int senhaNova) {
        if (admin != null && admin.cpf.equals(cpfAdmin) && admin.autenticar(senhaAtual)) {
            admin.setSenha(senhaNova);
            return true;
        }
        return false; // Não autenticado
    }
}
	
   