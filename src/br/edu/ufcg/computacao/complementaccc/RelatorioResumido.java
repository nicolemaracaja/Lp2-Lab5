package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe relatório resumido, que herda de Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioResumido extends Relatorio{

	/**
	 * Créditos por tipo de atividade.
	 */
	private Map<String, Double> creditosPorTipo;
	
	/**
	 * Créditos máximos por tipo de atividade.
	 */
    private Map<String, Double> creditosMaximosPorTipo;

    /**
     * Constrói o relatório resumido.
     * @param nome Nome do estudante. 
     * @param cpf CPF do estudante.
     * @param matricula Matrícula do estudante.
     * @param creditosPorTipo Créditos por tipo.
     * @param creditosMaximosPorTipo Créditos máximos por tipo.
     */
    public RelatorioResumido(String nome, String cpf, String matricula, Map<String, Double> creditosPorTipo, Map<String, Double> creditosMaximosPorTipo) {
        super(nome, cpf, matricula);
        this.creditosPorTipo = creditosPorTipo;
        this.creditosMaximosPorTipo = creditosMaximosPorTipo;
        this.creditosMaximosPorTipo = new HashMap<>();
        this.creditosPorTipo = new HashMap<>();
    }

    /**
     * Representação textual do relatório resumido.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório Resumido:\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Matrícula: ").append(matricula).append("\n");

        for (String tipo : creditosPorTipo.keySet()) {
            double creditos = creditosPorTipo.get(tipo);
            double maximos = creditosMaximosPorTipo.get(tipo);

            sb.append("Tipo: ").append(tipo)
              .append(", Créditos acumulados: ").append(creditos)
              .append(", Máximo permitido: ").append(maximos).append("\n");
        }

        return sb.toString();
    }
}
