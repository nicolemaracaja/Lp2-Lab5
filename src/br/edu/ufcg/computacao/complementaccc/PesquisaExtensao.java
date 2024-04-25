package br.edu.ufcg.computacao.complementaccc;

public class PesquisaExtensao extends Atividade {
    private int meses;
    private int maxCreditos = 18;

    public PesquisaExtensao(String codigo, String tipo, String descricao, String linkComprovacao, int meses) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.meses = meses;
    }

    @Override
    public int calcularCreditos() {
        return Math.min((meses / 12) * 10, maxCreditos);
    }
}
