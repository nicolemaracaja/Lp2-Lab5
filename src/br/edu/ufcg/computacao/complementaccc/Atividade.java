package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Atividade {

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
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public void setLinkComprovacao(String linkComprovacao) {
		this.linkComprovacao = linkComprovacao;
	}

	/**
	 * Calcula os créditos de uma respectiva atividade.
	 * @return 0 valor padrão para a super classe.
	 */
	public int calcularCreditos() {
		return 0;
	}
	
	/**
	 * Representação textual da atividade.
	 */
	public String toString() {
		return "Código: " + this.codigo + "\n" + "Tipo: " + this.tipo + "\n" +"Descrição: " + this.descricao + "\n" + "Link: " + this.linkComprovacao;
	}
	
}
