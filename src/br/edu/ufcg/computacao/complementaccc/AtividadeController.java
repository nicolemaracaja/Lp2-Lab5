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
	private Map<String, Estudante> estudantes;
	
	/**
	 * Constrói o Controller de atividades.
	 */
	public AtividadeController(Map<String, Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	
	/**
	 * Cria uma atividade do tipo MONITORIA.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipo Tipo da atividade.
	 * @param unidadeAcumulada Unidade acumulada (semestres).
	 * @param disciplina Disciplina.
	 * @return codigoATV Código da atividade.
	 */
	public String criarAtividadeMonitoria(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
        Estudante estudante = estudantes.get(cpf);
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        Monitoria monitoria = new Monitoria(tipo, unidadeAcumulada, disciplina);

        estudante.adicionarAtividade(codigo, monitoria);
        return codigo;
    }

	/**
	 * Cria uma atividade do tipo ESTÁGIO.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipo Tipo da atividade.
	 * @param unidadeAcumulada Unidade acumulada (horas).
	 * @param disciplina Disciplina.
	 * @return codigoATV Código da atividade.
	 */
    public String criarAtividadeEstagio(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
    	Estudante estudante = estudantes.get(cpf);
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        Estagio estagio = new Estagio(tipo, unidadeAcumulada, disciplina);

        estudante.adicionarAtividade(codigo, estagio);
        return codigo;
    }

    /**
     * Cria uma atividade do tipo PESQUISA DE EXTENSÃO.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param tipo Tipo da atividade.
     * @param unidadeAcumulada Unidade acumulada (meses).
     * @param disciplina Disciplina.
     * @return codigoATV Código da atividade.
     */
    public String criarAtividadePesquisaExtensao(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
    	Estudante estudante = estudantes.get(cpf);
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        PesquisaExtensao pesquisaExtensao = new PesquisaExtensao(tipo, unidadeAcumulada, disciplina);

        estudante.adicionarAtividade(codigo, pesquisaExtensao);
        return codigo;
    }

    /**
     * Cria uma atividade do tipo PUBLICAÇÃO.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param tipo Tipo da atividade.
     * @param unidadeAcumulada Unidade acumulada (0).
     * @param tituloArtigo Título do artigo.
     * @param doi DOI.
     * @param qualis Qualis.
     * @return codigoATV Código da atividade.
     */
    public String criarAtividadePublicacao(String cpf, String senha, String tipo, int unidadeAcumulada, String tituloArtigo, String doi, String qualis) {
    	Estudante estudante = estudantes.get(cpf);
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        String codigo = cpf + "_" + (estudante.getAtividades().size() + 1);
        Publicacao publicacao = new Publicacao(tipo, unidadeAcumulada, tituloArtigo, doi, qualis);

        estudante.adicionarAtividade(codigo, publicacao);
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
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        Map<String, Atividade> atividadesMap = estudante.getAtividades();
        Atividade atividade = atividadesMap.get(codigoAtividade);

        if (atividade != null) {
            // Se a atividade for encontrada, atualize o link de comprovação
            atividade.setDescricao(novaDescricao);
            return true;
        }

        return false; // Atividade não encontrada
    }
    
    /**
     * Pega a descrição da atividade.
     * @param atividade Atividade.
     * @return descrição Descrição da atividade.
     */
    public String getDescricaoAtividade(Atividade atividade) {
    	return atividade.getDescricao();
    }
    
    /**
     * Pega o link comprobatório da atividade.
     * @param atividade Atividade.
     * @return link Link comprobatório..
     */
    public String getComprovacaoAtividade(Atividade atividade) {
    	return atividade.getLinkComprovacao();
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
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }

        Map<String, Atividade> atividadesMap = estudante.getAtividades();
        Atividade atividade = atividadesMap.get(codigoAtividade);

        if (atividade != null) {
            // Se a atividade for encontrada, atualize o link de comprovação
            atividade.setLinkComprovacao(novoLinkComprovacao);
            return true;
        }

        return false; // Atividade não encontrada
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
        if (!estudante.autenticar(senha)) {
            throw new IllegalArgumentException("AUTENTICAÇÃO FALHOU!");
        }
        
        Map<String, Atividade> atividadesMap = estudante.getAtividades();
        Atividade atividade = atividadesMap.get(codigoAtividade);

        if (atividade == null) {
        	throw new IllegalArgumentException("CÓDIGO INVÁLIDO!"); //atividade não encontrada
            // Se a atividade não for encontrada
        }
        return atividade.calcularCreditos();
    }
}