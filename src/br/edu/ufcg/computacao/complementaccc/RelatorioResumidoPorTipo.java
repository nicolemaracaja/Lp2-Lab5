package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe relatório resumido por tipo, que herda de Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioResumidoPorTipo extends Relatorio{

	/**
	 * Tipo da atividade.
	 */
	private String tipo;
	
	/**
	 * Créditos da atividade.
	 */
    private double creditos;
    
    /**
     * Máximo de créditos permitido.
     */
    private double maximos;

    /**
     * Constrói o relatório resumido por tipo.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param matricula Matrícula do estudante.
     * @param tipo Tipo da atividade.
     * @param creditos Créditos da atividade.
     * @param maximos Máximo de créditos da atividade.
     */
    public RelatorioResumidoPorTipo(UsuarioController uc, String nome, String cpf, String matricula, String tipo, double creditos, double maximos) {
        super(uc, nome, cpf, matricula);
        this.tipo = tipo;
        this.creditos = creditos;
        this.maximos = maximos;
    }

    /**
     * Representação textual do relatório resumido por tipo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório Resumido por Tipo de Atividade:\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Matrícula: ").append(matricula).append("\n");
        sb.append("Tipo: ").append(tipo)
          .append(", Créditos acumulados: ").append(creditos)
          .append(", Máximo permitido: ").append(maximos).append("\n");

        return sb.toString();
    }
}
