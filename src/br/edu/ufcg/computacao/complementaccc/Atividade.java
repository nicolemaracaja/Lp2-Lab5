package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public abstract class Atividade implements Comparable<Atividade>{

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
	 * Unidade acumulada.
	 */
	protected int unidadeAcumulada;
	
	/**
	 * Constrói a atividade.
	 * @param tipo Tipo da atividade.
	 * @param descricao Descrição da atividade.
	 * @param codigo Código da atividade.
	 * @param linkComprovacao Link
	 */
	public Atividade(String tipo, int unidadeAcumulada) {
		if (tipo.isBlank() || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("TIPO INVÁLIDO!");
    }
		if (unidadeAcumulada < 0) {
			throw new IllegalArgumentException("VALOR NUMÉRICO INVÁLIDO!");
		}
		this.tipo = tipo;
		this.unidadeAcumulada = unidadeAcumulada;
		this.codigo = "";
		this.descricao = "";
		this.linkComprovacao = "";
	}

	/**
	 * Pega o código da atividade.
	 * @return codigo Código da atividade.
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Pega o tipo da atividade.
	 * @return tipo Tipo da atividade.
	 */
	public String getTipo() {
		return this.tipo;
	}
	
	public int getUnidadeAcumulada() {
		return this.unidadeAcumulada;
	}
	
	/**
	 * Pega a descrição da atividade.
	 * @return descricao Descrição da atividade.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Muda a descrição da atividade.
	 * @param descricao Nova descrição da atividade.
	 */
	public void setDescricao(String novaDescricao) {
		if (novaDescricao.isBlank() || novaDescricao.trim().isEmpty()) {
            throw new IllegalArgumentException("DESCRIÇÃO INVÁLIDA!");
        }
		this.descricao = novaDescricao;
	}

	/**
	 * Pega o link de comprovação da atividade.
	 * @return linkComprovacao Link do documento comprobatório.
	 */
	public String getLinkComprovacao() {
		return this.linkComprovacao;
	}

	/**
	 * Muda o link de comprovação da atividade.
	 * @param linkComprovacao Novo link do documento comprobatório.
	 */
	public void setLinkComprovacao(String novoLinkComprovacao) {
		if (novoLinkComprovacao.isBlank() || novoLinkComprovacao.trim().isEmpty()) {
            throw new IllegalArgumentException("LINK DE COMPROVAÇÃO INVÁLIDO!");
        }
		this.linkComprovacao = novoLinkComprovacao;
	}

	/**
	 * Calcula os créditos de uma respectiva atividade.
	 */
	public abstract double calcularCreditos();

	/**
	 * Representação textual da atividade.
	 */
	@Override
	public abstract String toString();
	
	public int CompareTo(Atividade o) {
		return this.tipo.compareTo(o.tipo);
	}
}
