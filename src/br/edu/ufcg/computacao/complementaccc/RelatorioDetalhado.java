package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe Relatório Detalhado, que herda de Relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioDetalhado extends Relatorio{

	/**
	 * ArrayList de atividades.
	 */
	private List<Atividade> atividades;

	/**
	 * Constrói o relatório detalhado.
	 * @param nome Nome do estudante.
	 * @param cpf CPF do estudante.
	 * @param matricula Matrícula do estudante.
	 * @param atividades Atividades.
	 */
    public RelatorioDetalhado(String nome, String cpf, String matricula, List<Atividade> atividades) {
        super(nome, cpf, matricula);
        this.atividades = atividades;
    }

    /**
     * Representação textual do relatório detalhado.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório Detalhado:\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Matrícula: ").append(matricula).append("\n");
        sb.append("Atividades:\n");

        // Ordenar por tipo
        atividades.sort(Comparator.comparing(Atividade::getTipo));

        for (Atividade atividade : atividades) {
            sb.append(atividade.toString()).append("\n");
        }

        return sb.toString();
    }

}
