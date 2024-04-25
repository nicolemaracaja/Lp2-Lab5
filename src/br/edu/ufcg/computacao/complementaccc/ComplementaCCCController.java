package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe controller que implementa as funções do sistema.
 */
public class ComplementaCCCController {

	/**
	 * Mapa dos usuários, identificados pelo seu CPF.
	 */
	private HashMap<String, Usuario> usuarios;
	
	/**
	 * ArrayList de atividades.
	 */
	private List<Atividade> atividades;
	
	/**
	 * Cria o controller ComplementaCCC.
	 */
	public ComplementaCCCController() {
		this.usuarios = new HashMap<>();
		this.atividades = new ArrayList<>();	
	}
	
	/**
	 * Cria um estudante com base em seu nome, seu cpf, sua senha e sua matrícula.
	 * @param nome Nome do estudante.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param matricula Matrícula do estudante.
	 * @return um valor booleano, true se tiver adicionado, se não, false.
	 */
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return false;
		
	}
	
	public String[] exibirEstudantes(String cpf, int senha){
		return null;
		
	}
	
	public boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		
		return false;		
	}
	
	public String exibirAdmin(String cpf, int senha){
		return cpf;
		//ADMIN
	}
	
	public boolean configurarNovoADMIN(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova){
		return false;
		//ADMIN
	}
	
	public boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		return false;
		//ADMIN
	}

}
