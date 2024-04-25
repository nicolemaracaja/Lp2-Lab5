package br.edu.ufcg.computacao.complementaccc;

public class Atividade {

	protected String tipo;
	protected String descricao;
	protected String codigo;
	protected String linkComprovacao;
	
	public Atividade(String tipo, String descricao, String codigo, String linkComprovacao) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.codigo = codigo;
		this.linkComprovacao = linkComprovacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkComprovacao() {
		return linkComprovacao;
	}

	public void setLinkComprovacao(String linkComprovacao) {
		this.linkComprovacao = linkComprovacao;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public int calcularCreditos() {
		return 0;
	}
}
