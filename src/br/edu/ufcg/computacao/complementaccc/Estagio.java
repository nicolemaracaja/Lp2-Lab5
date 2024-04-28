package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Estágio, que possui herança de Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Estagio extends Atividade {
	
	/**
	 * Carga horária cumprida.
	 */
    private int horas;
    
    /**
     * Máximo de créditos possíveis de conseguir no Estágio.
     */
    private int maxCreditos = 18;

    /**
     * Constrói a atividade Estágio.
     * @param codigo Código da atividade.
     * @param tipo Tipo da atividade.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link do documento comprobatório do Estágio.
     * @param horas Horas cumpridas no estágio.
     */
    public Estagio(String codigo, String tipo, String descricao, String linkComprovacao, int horas) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.horas = horas;
    }

    /**
     * Calcula a quantidade de créditos acumulados pelo usuário, não podendo ultrapassar 18 créditos.
     */
    @Override
    public int calcularCreditos() {
        return Math.min(horas / 60, maxCreditos); //1 crédito a cada 60 horas.
    }
    
    /**
     * Representação textual da atividade Estágio.
     */
    @Override
    public String toString() {
    	return super.toString() + "\n" + "Horas: " + this.horas;
    }
}
