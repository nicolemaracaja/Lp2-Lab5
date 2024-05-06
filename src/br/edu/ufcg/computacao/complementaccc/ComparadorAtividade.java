package br.edu.ufcg.computacao.complementaccc;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Classe que compara as atividades, de acordo com o seu tipo.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class ComparadorAtividade implements Comparator<Atividade>{
	
	private HashMap<String, Integer> ordemDosTipos = new HashMap<>();
	
	public ComparadorAtividade() {
		this.ordemDosTipos.put("ESTAGIO", 1);
		this.ordemDosTipos.put("MONITORIA", 2);
		this.ordemDosTipos.put("PESQUISA_EXTENSAO", 3);
		this.ordemDosTipos.put("PUBLICACAO", 4);
		this.ordemDosTipos.put("PUBLICACAO_PERIODICA", 5);
		this.ordemDosTipos.put("PUBLICACAO_CONFERENCIA", 6);
	}

	@Override
	public int compare(Atividade o1, Atividade o2) {
		return this.ordemDosTipos.get(o1.getTipo()) - this.ordemDosTipos.get(o2.getTipo());
	}

}