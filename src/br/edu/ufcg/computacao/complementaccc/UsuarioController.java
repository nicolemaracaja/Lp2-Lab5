package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

public class UsuarioController {

	private List<Estudante> estudantes;
	private Admin admin;
	
	public UsuarioController() {
		this.estudantes = new ArrayList<>();
	}
	
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
        for (Estudante estudante : estudantes) {
            if (estudante.cpf.equals(cpf)) {
                return false; // CPF já cadastrado
            }
        }
        estudantes.add(new Estudante(nome, cpf, senha, matricula));
        return true;
    }

    public String[] exibirEstudantes(String cpfAdmin, int senhaAdmin) {
        if (admin == null || !admin.cpf.equals(cpfAdmin) || !admin.autenticar(senhaAdmin)) {
            return null; // Não autenticado
        }

        Collections.sort(estudantes, (e1, e2) -> e1.nome.compareTo(e2.nome)); // Ordenar por nome
        String[] resultado = new String[estudantes.size()];
        for (int i = 0; i < estudantes.size(); i++) {
            resultado[i] = estudantes.get(i).toString();
        }
        return resultado;
    }

    public boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
        for (Estudante estudante : estudantes) {
            if (estudante.cpf.equals(cpf) && estudante.autenticar(senha)) {
                switch (tipoAlteracao.toLowerCase()) {
                    case "nome":
                        estudante.nome = novoValor;
                        return true;
                    case "matricula":
                        estudante.matricula = novoValor;
                        return true;
                    case "senha":
                        estudante.senha = Integer.parseInt(novoValor);
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false; // Estudante não encontrado ou senha incorreta
    }

    public String exibirAdmin(String cpfAdmin, int senhaAdmin) {
        if (admin == null || !admin.cpf.equals(cpfAdmin) || !admin.autenticar(senhaAdmin)) {
            return null; // Não autenticado
        }
        return admin.toString();
    }

    public boolean configurarNovoADMIN(String cpfAdmin, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova) {
        if (admin == null || (admin.cpf.equals(cpfAdmin) && admin.autenticar(senhaAtual))) {
            admin = new Admin(nomeNovo, cpfNovo, senhaNova); // Configurar ou reconfigurar ADMIN
            return true;
        }
        return false; // Não autenticado
    }

    public boolean configurarSenhaADMIN(String cpfAdmin, int senhaAtual, int senhaNova) {
        if (admin != null && admin.cpf.equals(cpfAdmin) && admin.autenticar(senhaAtual)) {
            admin.setSenha(senhaNova);
            return true;
        }
        return false; // Não autenticado
    }
}
	
   

