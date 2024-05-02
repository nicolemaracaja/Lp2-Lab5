package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Pesquisa de Extensão, que possui herança de Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class PesquisaExtensao extends Atividade {
	
    /**
     * Máximo de créditos possíveis de conseguir na atividade de extensão.
     */
    private int maxCreditos = 18;
    
    /**
     * Disciplina.
     */
    private String disciplina;

    /**
     * Constrói a Pesquisa de Extensão.
     * @param codigo Código da atividade.
     * @param tipo Tipo da atividade.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link do documento comprobatório da pesquisa de extensão.
     * @param meses Quantidade de meses de duração da atividade de extensão.
     */
    public PesquisaExtensao(String tipo, int unidadeAcumulada, String disciplina) {
        super(tipo, unidadeAcumulada);
        if (disciplina.isBlank() || disciplina.isEmpty()) {
        	throw new IllegalArgumentException("DISCIPLINA INVÁLIDA!");
        }
        this.disciplina = disciplina;
    }
    
    /**
     * Calcula a quantidade de créditos obtidos pelo usuário, não podendo ultrapassar 18 créditos.
     */
    @Override
    public int calcularCreditos() {
        return Math.min((unidadeAcumulada / 12) * 10, maxCreditos);
    }
    
    /**
     * Representação textual da atividade Pesquisa de Extensão.
     */
    @Override
    public String toString() {
    	return "Pesquisa de Extensão" + "\n" + "Quantidade de meses: " + this.unidadeAcumulada;
    }
}
