package br.edu.ufcg.computacao.complementaccc;

public class Estagio extends Atividade {
    private int horas;
    private int maxCreditos = 18;

    public Estagio(String codigo, String tipo, String descricao, String linkComprovacao, int horas) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.horas = horas;
    }

    @Override
    public int calcularCreditos() {
        return Math.min(horas / 60, maxCreditos);
    }
}
