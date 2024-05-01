package br.edu.ufcg.computacao.complementaccc;

import java.util.*;
/**
 * Classe que implementa as funcionalidades relacionadas a Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class AtividadeController {

	/**
	 * Mapa de estudantes.
	 */
	private HashMap<String, Estudante> estudantes;
	
	/**
	 * Constrói o Controller de atividades.
	 */
	public AtividadeController() {
		this.estudantes = new HashMap<>();
	}
	
	/**
	 * Cria uma atividade do tipo MONITORIA.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param descricao Descrição da atividade.
	 * @param linkComprovacao Link para o documento comprobatório.
	 * @param disciplina Disciplina que o estudante aplica monitoria.
	 * @param semestreLetivo Semestre que o estudante aplica monitoria;
	 * @return codigo Código da atividade.
	 */
	public String criarAtividadeMonitoria(String cpf, String senha, String descricao, String linkComprovacao, String disciplina, int semestreLetivo) {
        Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        Monitoria monitoria = new Monitoria(descricao, codigo, linkComprovacao, disciplina, semestreLetivo);

        estudante.adicionarAtividade(monitoria);
        return codigo;
    }

	/**
	 * Cria uma atividade do tipo ESTÁGIO.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param descricao Descrição da atividade.
	 * @param linkComprovacao Link para o documento comprobatório.
	 * @param cargaHoraria Carga horária do estágio.
	 * @return codigo Código da atividade.
	 */
    public String criarAtividadeEstagio(String cpf, String senha, String descricao, String linkComprovacao, int cargaHoraria) {
    	Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        Estagio estagio = new Estagio(descricao, codigo, linkComprovacao, cargaHoraria);

        estudante.adicionarAtividade(estagio);
        return codigo;
    }

    /**
     * Cria uma atividade do tipo PESQUISA DE EXTENSÃO.
     * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param descricao Descrição da atividade.
	 * @param linkComprovacao Link para o documento comprobatório.
     * @param meses Meses da pesquisa de extensão.
     * @return codigo Código da atividade.
     */
    public String criarAtividadePesquisaExtensao(String cpf, String senha, String descricao, String linkComprovacao, int meses) {
    	Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        PesquisaExtensao pesquisaExtensao = new PesquisaExtensao(descricao, codigo, linkComprovacao, meses);

        estudante.adicionarAtividade(pesquisaExtensao);
        return codigo;
    }

    /**
     * Cria uma atividade do tipo PUBLICAÇÃO.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link para o documento comprobatório.
     * @param tituloArtigo Título do artigo que será publicado.
     * @param doi DOI.
     * @param qualis Qualis.
     * @return codigo Código da atividade.
     */
    public String criarAtividadePublicacao(String cpf, String senha, String descricao, String linkComprovacao, String tituloArtigo, String doi, String qualis) {
    	Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        Publicacao publicacao = new Publicacao(descricao, codigo, linkComprovacao, tituloArtigo, doi, qualis);

        estudante.adicionarAtividade(publicacao);
        return codigo;
    }

    /**
     * Altera a descrição da atividade.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param codigoAtividade Código da atividade.
     * @param novaDescricao Nova descrição.
     * @return true, se a alteração tiver tido sucesso, se não, false.
     */
    public boolean alterarDescricaoAtividade(String cpf, String senha, String codigoAtividade, String novaDescricao) {
    	Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        for (Atividade atividade : estudante.getAtividades()) {
            if (atividade.getCodigo().equals(codigoAtividade)) {
                atividade.setDescricao(novaDescricao);
                return true;
            }
        }
        return false;
    }

    /**
     * Altera o link do documento comprobatório da atividade.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param codigoAtividade Código da atividade.
     * @param novoLinkComprovacao Novo link de comprovação.
     * @return true, se a alteração tiver tido sucesso, se não, false.
     */
    public boolean alterarComprovacaoAtividade(String cpf, String senha, String codigoAtividade, String novoLinkComprovacao) {
    	Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        for (Atividade atividade : estudante.getAtividades()) {
            if (atividade.getCodigo().equals(codigoAtividade)) {
                atividade.setLinkComprovacao(novoLinkComprovacao);
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula os créditos da atividade.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param codigoAtividade Código da atividade.
     * @return creditos Os créditos da atividade.
     */
    public double calcularCreditos(String cpf, String senha, String codigoAtividade) {
    	Estudante estudante = estudantes.get(cpf);
        if (estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        for (Atividade atividade : estudante.getAtividades()) {
            if (atividade.getCodigo().equals(codigoAtividade)) {
                return atividade.calcularCreditos();
            }
        }
        throw new IllegalArgumentException("CÓDIGO INVÁLIDO!");
    }
}
