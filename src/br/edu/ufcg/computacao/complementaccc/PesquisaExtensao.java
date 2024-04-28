package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Pesquisa de Extensão, que possui herança de Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class PesquisaExtensao extends Atividade {
	
	/**
	 * Quantidade de meses que o usuário participa da atividade de extensão.
	 */
    private int meses;
    
    /**
     * Máximo de créditos possíveis de conseguir na atividade de extensão.
     */
    private int maxCreditos = 18;

    /**
     * Constrói a Pesquisa de Extensão.
     * @param codigo Código da atividade.
     * @param tipo Tipo da atividade.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link do documento comprobatório da pesquisa de extensão.
     * @param meses Quantidade de meses de duração da atividade de extensão.
     */
    public PesquisaExtensao(String codigo, String tipo, String descricao, String linkComprovacao, int meses) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.meses = meses;
    }

    /**
     * Calcula a quantidade de créditos acumulados pelo usuário, não podendo ultrapassar 18 créditos.
     */
    @Override
    public int calcularCreditos() {
        return Math.min((meses / 12) * 10, maxCreditos);
    }
    
    /**
     * Representação textual da atividade Pesquisa de Extensão.
     */
    @Override
    public String toString() {
    	return super.toString() + "Quantidade de meses: " + this.meses;
    }
}
