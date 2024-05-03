package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Monitoria, que possui herança de Atividade.
 * @author Nicole Brito Maracajá - 123111413
 */
public class Monitoria extends Atividade {
	
	/**
	 * Disciplina que o usuário aplica a monitoria
	 */
    private String disciplina;
    
    /**
     * Máximo de créditos possíveis de conseguir na monitoria.
     */
    private int maxCreditos = 16;

    /**
     * Constrói a atividade Monitoria.
     * @param codigo Código da atividade.
     * @param tipo Tipo da atividade.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link do documento comprobatório da atividade.
     * @param disciplina Disciplina que o usuário aplica monitoria.
     * @param semestre Semestre.
     */
    public Monitoria(String tipo, int unidadeAcumulada, String disciplina) {
        super(tipo, unidadeAcumulada);
        if (disciplina.isBlank() || disciplina.trim().isEmpty()) {
            throw new IllegalArgumentException("DISCIPLINA INVÁLIDA!");
        }
        this.disciplina = disciplina;
    }

    /**
     * Calcula a quantidade de créditos acumulados pelo usuário, não podendo ultrapassar 16 créditos.
     */
    @Override
    public double calcularCreditos() {
        return Math.min(unidadeAcumulada * 4, maxCreditos); //não pode ultrapassar 16 créditos.
    }
    
    /**
     * Representação textual da atividade Monitoria.
     */
    @Override
    public String toString() {
    	return "Monitoria" + "\n" + "Disciplina: " + this.disciplina;
    }

	@Override
	public int compareTo(Atividade o) {
		return this.tipo.compareTo(o.tipo);
	}

}
