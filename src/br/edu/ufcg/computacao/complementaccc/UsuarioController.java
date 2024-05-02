package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe UsuarioController, que manipula as funções relacionadas ao usuário.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class UsuarioController{

	/**
	 * Mapa de estudantes cadastrados no sistema.
	 */
	private Map<String, Estudante> estudantes;
	
	/**
	 * Administrador do sistema.
	 */
	private Admin admin;
	
	/**
	 * Constrói o UsuárioController.
	 */
	public UsuarioController() {
		this.estudantes = new HashMap<>();
		this.admin = new Admin("admin", "000.000.000-00", "00000000");
	}
		
	/**
     * Cria um estudante com base em seu nome, seu cpf, sua senha e sua matrícula.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param matricula Matrícula do estudante.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
	public boolean criarEstudante(String nome, String cpf, String senha, String matricula) throws IllegalArgumentException{
		if(nome.isBlank() || nome.isEmpty()) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}
		if(cpf.isBlank() || cpf.isEmpty()) {
			throw new IllegalArgumentException("CPF INVÁLIDO!");
		}
		if (senha.length() != 8) {
			throw new IllegalArgumentException("SENHA INVÁLIDA!");
		}
		
        for (Estudante estudante : estudantes.values()) {
            if (estudante.cpf.equals(cpf)) {
                throw new IllegalArgumentException("CPF JÁ CADASTRADO!"); // CPF já cadastrado
            }
        }
        estudantes.put(cpf, new Estudante(nome, cpf, senha, matricula));
        return true; //Estudante cadastrado no sistema
    }

	 /**
     * Exibe todos os estudantes se autenticado com admin.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return Array de strings com informações dos estudantes, ou null se a autenticação falhar.
     */
    public String[] exibirEstudantes(String cpfAdmin, String senhaAdmin) {
    	if(cpfAdmin.isBlank() || cpfAdmin.isEmpty()) {
			throw new IllegalArgumentException("CPF INVÁLIDO!");
		}
        if (!admin.cpf.equals(cpfAdmin) || !admin.autenticar(senhaAdmin)) {
            throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado
        }

        ArrayList<Estudante> estudantes2 = new ArrayList<>(estudantes.values());
        
        Collections.sort(estudantes2); // Ordenar por nome
        String[] resultado = new String[estudantes.size()];
        
        for (int i = 0; i < estudantes.size(); i++) {
            resultado[i] = estudantes2.get(i).getNome();
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
    public boolean alterarEstudante(String cpf, String senha, String tipoAlteracao, String novoValor) {
		if(cpf.isBlank() || cpf.isEmpty()) {
			throw new IllegalArgumentException("CPF INVÁLIDO!");
		}
		
        for (Estudante estudante : estudantes.values()) {
            if (estudante.cpf.equals(cpf) && estudante.autenticar(senha)) {
                switch (tipoAlteracao.toLowerCase()) {
                    case "nome":
                        estudante.setNome(novoValor);
                        return true;
                    case "matricula":                   	
                        estudante.setMatricula(novoValor);
                        return true;
                    case "senha":           
                        estudante.setSenha(novoValor);
                        return true;
                    default:
                        return false;
                }
            }
        }
        throw new IllegalArgumentException("SENHA INVÁLIDA!"); // Estudante não encontrado ou senha incorreta
    }

    /**
     * Exibe informações do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return String com informações do admin, ou null se a autenticação falhar.
     */
    public String exibirAdmin(String cpfAdmin, String senhaAdmin) {
        if (!admin.cpf.equals(cpfAdmin) || !admin.autenticar(senhaAdmin)) {
        	throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado
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
    public boolean configurarNovoADMIN(String cpfAdmin, String senhaAtual, String nomeNovo, String cpfNovo, String senhaNova) {
    	if(nomeNovo.isBlank() || nomeNovo.isEmpty()) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}
		if(cpfNovo.isBlank() || cpfNovo.isEmpty()) {
			throw new IllegalArgumentException("CPF INVÁLIDO!");
		}
		if (senhaNova.length() != 8) {
			throw new IllegalArgumentException("SENHA INVÁLIDA!");
		}
		
    	if ((admin.cpf.equals(cpfAdmin) && admin.autenticar(senhaAtual))) {
            admin = new Admin(nomeNovo, cpfNovo, senhaNova); // Configurar ou reconfigurar ADMIN
            return true;
        }
        throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado
    }

    /**
     * Altera a senha do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAtual Senha atual do admin.
     * @param senhaNova Nova senha do admin.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
    public boolean configurarSenhaADMIN(String cpfAdmin, String senhaAtual, String senhaNova) {
        if (!admin.cpf.equals(cpfAdmin) || !admin.autenticar(senhaAtual)) {
            throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado
        }
    	if (senhaNova.length() != 8) {
    			throw new IllegalArgumentException("SENHA INVÁLIDA!");
    	}
        admin.setSenha(senhaNova);
        return true;
    }
       
    
	/**
	 * Pega o administrador do sistema.
	 * @return admin Administrador do sistema.
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * Pega os estudantes do sistema.
	 * @return estudantes Estudantes do sistema.
	 */
	public Map<String, Estudante> getEstudantes() {
		return this.estudantes;
	}

}
	
   