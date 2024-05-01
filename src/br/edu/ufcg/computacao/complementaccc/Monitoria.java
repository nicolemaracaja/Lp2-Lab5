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
     * Semestre que o usuário está aplicando a monitoria.
     */
    private int semestre;
    
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
     * @param semestre Semestre que o usuário está aplicando a monitoria.
     */
    public Monitoria(String codigo, String descricao, String linkComprovacao, String disciplina, int semestre) {
        super(codigo, "MONITORIA", descricao, linkComprovacao);
        if (disciplina.isBlank() || disciplina.trim().isEmpty()) {
            throw new IllegalArgumentException("DISCIPLINA INVÁLIDA!");
        }
        if (semestre < 0) {
            throw new IllegalArgumentException("SEMESTRE INVÁLIDO!");
        }
        this.disciplina = disciplina;
        this.semestre = semestre;
    }

    /**
     * Calcula a quantidade de créditos acumulados pelo usuário, não podendo ultrapassar 16 créditos.
     */
    @Override
    public int calcularCreditos() {
        return Math.min(semestre * 4, maxCreditos); //não pode ultrapassar 16 créditos.
    }
    
    /**
     * Representação textual da atividade Monitoria.
     */
    @Override
    public String toString() {
    	return "Monitoria" + "\n" + "Disciplina: " + this.disciplina + "\n" + "Semestre: " + this.semestre;
    }

}
