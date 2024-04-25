package br.edu.ufcg.computacao.complementaccc;

public class Monitoria extends Atividade {
	
    private String disciplina;
    private int semestreLetivo;
    private int maxCreditos = 16;

    public Monitoria(String codigo, String tipo, String descricao, String linkComprovacao, String disciplina, int semestreLetivo) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.disciplina = disciplina;
        this.semestreLetivo = semestreLetivo;
    }

    @Override
    public int calcularCreditos() {
        return Math.min(semestreLetivo * 4, maxCreditos);
    }
}
