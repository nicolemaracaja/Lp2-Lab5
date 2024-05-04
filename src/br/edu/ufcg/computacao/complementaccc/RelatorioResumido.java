package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe relatório resumido, que herda de Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioResumido extends Relatorio{

    /**
     * Constrói o relatório resumido.
     * @param nome Nome do estudante. 
     * @param cpf CPF do estudante.
     * @param matricula Matrícula do estudante.
     */
	public RelatorioResumido(String nome, String cpf, String matricula) {
        super(nome, cpf, matricula);
    }

    /**
     * Representação textual do relatório resumido.
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Relatório Resumido\n");
        sb.append("Nome: ").append(nome)
          .append(", CPF: ").append(cpf)
          .append(", Matrícula: ").append(matricula).append("\n");

        Map<String, Double> creditosPorTipo = new HashMap<>();
        for (Atividade atividade : atividadesRelatorio) {
            String tipo = atividade.getTipo();
            
            double creditos = atividade.calcularCreditos();
            creditosPorTipo.merge(tipo, creditos, Double::sum); // Sumarizar créditos por tipo

            sb.append("Tipo: ").append(tipo)
              .append(", Descrição: ").append(atividade.getDescricao())
              .append(", Créditos Acumulados: ").append(creditos)
              .append("\n");
        }

        return sb.toString(); // Sumarização dos créditos acumulados por tipo de atividade
    }
}
