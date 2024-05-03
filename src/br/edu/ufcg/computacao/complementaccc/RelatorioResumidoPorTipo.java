package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe relatório resumido por tipo, que herda de Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioResumidoPorTipo extends Relatorio{

	/**
	 * Tipo da atividade.
	 */
	private String tipoAtividade;
	
    /**
     * Constrói o relatório resumido por tipo.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param matricula Matrícula do estudante.
     * @param tipo Tipo da atividade.
     */
	public RelatorioResumidoPorTipo(String nome, String cpf, String matricula, String tipoAtividade) {
        super(nome, cpf, matricula);
        this.tipoAtividade = tipoAtividade;
    }

    /**
     * Representação textual do relatório resumido por tipo.
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Relatório por Atividade (").append(tipoAtividade).append(")\n");
        sb.append("Nome: ").append(nome).append(", CPF: ").append(cpf).append(", Matrícula: ").append(matricula).append("\n");

        double creditosAcumulados = 0.0;
        for (Atividade atividade : atividadesRelatorio) {
            if (atividade.getTipo().equals(tipoAtividade)) {
                creditosAcumulados += atividade.calcularCreditos(); // Somar créditos por atividade
            }
        }

        sb.append("Créditos Acumulados: ").append(creditosAcumulados).append("\n");

        return sb.toString(); // Retorna a sumarização para o tipo de atividade
    }
}
