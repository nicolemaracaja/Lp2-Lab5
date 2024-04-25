package br.edu.ufcg.computacao.complementaccc;

public class Publicacao extends Atividade {
	
    private String tituloArtigo;
    private String doi;
    private String qualis;

    public Publicacao(String codigo, String tipo, String descricao, String linkComprovacao, String tituloArtigo, String doi, String qualis) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.tituloArtigo = tituloArtigo;
        this.doi = doi;
        this.qualis = qualis;
    }

    @Override
    public int calcularCreditos() {
        // Por padrão, considere 2 créditos para Qualis A3, ajustável conforme resolução
        return qualis.equals("A3") ? 2 : 1; // Exemplo
    }
}
