package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe Relatório Detalhado, que herda de Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioDetalhado extends Relatorio{

	/**
	 * Constrói o relatório detalhado.
	 * @param nome Nome do estudante.
	 * @param cpf CPF do estudante.
	 * @param matricula Matrícula do estudante.
	 */
	public RelatorioDetalhado(String nome, String cpf, String matricula) {
        super(nome, cpf, matricula);
    }

    /**
     * Representação textual do relatório detalhado.
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Relatório Completo\n");
        sb.append("Nome: ").append(nome)
          .append(", CPF: ").append(cpf)
          .append(", Matrícula: ").append(matricula).append("\n");

        // Ordenar por tipo de atividade
        atividadesRelatorio.sort(Comparator.comparing(Atividade::getTipo));

        for (Atividade atividade : atividadesRelatorio) {
            sb.append("Tipo: ").append(atividade.getTipo())
              .append(", Descrição: ").append(atividade.getDescricao())
              .append(", Créditos: ").append(atividade.calcularCreditos())
              .append("\n");
        }

        return sb.toString(); // Representação textual do relatório detalhado
    }
}
