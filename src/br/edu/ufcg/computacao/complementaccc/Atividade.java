package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public abstract class Atividade {

	/**
	 * Tipo da atividade.
	 */
	protected String tipo;
	
	/**
	 * Descrição da atividade.
	 */
	protected String descricao;
	
	/**
	 * Código da atividade.
	 */
	protected String codigo;
	
	/**
	 * Link para documentaçãop comprobatória.
	 */
	protected String linkComprovacao;
	
	/**
	 * Constrói a atividade.
	 * @param tipo Tipo da atividade.
	 * @param descricao Descrição da atividade.
	 * @param codigo Código da atividade.
	 * @param linkComprovacao Link
	 */
	public Atividade(String tipo, String descricao, String codigo, String linkComprovacao) {
		if (tipo.isBlank() || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("TIPO INVÁLIDO!");
    }
		if (descricao.isBlank() || descricao.trim().isEmpty()) {
	            throw new IllegalArgumentException("DESCRIÇÃO INVÁLIDA!");
	    }
		if (codigo.isBlank() || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("CÓDIGO INVÁLIDO!");
        }
        if (linkComprovacao == null || linkComprovacao.trim().isEmpty()) {
            throw new IllegalArgumentException("LINK DE COMPROVAÇÃO INVÁLIDO!");
        }
		this.tipo = tipo;
		this.descricao = descricao;
		this.codigo = codigo;
		this.linkComprovacao = linkComprovacao;
	}

	/**
	 * Pega o código da atividade.
	 * @return codigo Código da atividade.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Pega o tipo da atividade.
	 * @return tipo Tipo da atividade.
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Pega a descrição da atividade.
	 * @return descricao Descrição da atividade.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Muda a descrição da atividade.
	 * @param descricao Nova descrição da atividade.
	 */
	public void setDescricao(String novaDescricao) {
		if (descricao .isBlank() || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("DESCRIÇÃO INVÁLIDA!");
        }
		this.descricao = novaDescricao;
	}

	/**
	 * Pega o link de comprovação da atividade.
	 * @return linkComprovacao Link do documento comprobatório.
	 */
	public String getLinkComprovacao() {
		return linkComprovacao;
	}

	/**
	 * Muda o link de comprovação da atividade.
	 * @param linkComprovacao Novo link do documento comprobatório.
	 */
	public void setLinkComprovacao(String novoLinkComprovacao) {
		if (linkComprovacao.isBlank() || linkComprovacao.trim().isEmpty()) {
            throw new IllegalArgumentException("LINK DE COMPROVAÇÃO INVÁLIDO!");
        }
		this.linkComprovacao = novoLinkComprovacao;
	}

	/**
	 * Calcula os créditos de uma respectiva atividade.
	 */
	public abstract int calcularCreditos();

	/**
	 * Representação textual da atividade.
	 */
	@Override
	public abstract String toString();
	
}
