package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Estágio, que possui herança de Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Estagio extends Atividade {
	
    /**
     * Máximo de créditos possíveis de conseguir no Estágio.
     */
    private int maxCreditos = 18;
    
    /**
     * Disciplina.
     */
    private String disciplina;

    /**
     * Constrói a atividade Estágio.
     * @param codigo Código da atividade.
     * @param tipo Tipo da atividade.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link do documento comprobatório do Estágio.
     * @param horas Horas cumpridas no estágio.
     */
    public Estagio(String tipo, int unidadeAcumulada, String disciplina) {
        super(tipo, unidadeAcumulada);
        if (disciplina.isBlank() || disciplina.isEmpty()) {
            throw new IllegalArgumentException("DISCIPLINA INVÁLIDA!");
        }
        this.disciplina = disciplina;
    }
    
    /**
     * Calcula a quantidade de créditos obtida pelo usuário, não podendo ultrapassar 18 créditos.
     */
    @Override
    public double calcularCreditos() {
    	return Math.min(unidadeAcumulada / 60, maxCreditos); //1 crédito a cada 60 horas.
    }
     
    /**
     * Representação textual da atividade Estágio.
     */
    @Override
    public String toString() {
    	return "Estágio" + "\n" + "Horas: " + this.unidadeAcumulada;
    }

	@Override
	public int compareTo(Atividade o) {
		return this.tipo.compareTo(o.tipo);
	}
}
