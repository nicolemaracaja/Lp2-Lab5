package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe comparador de ItemFAQ.
 * @author Nicole Brito Maracajá - 12311413.
 */
public class ComparadorFAQ implements Comparator<ItemFAQ>{

	@Override
	public int compare(ItemFAQ o1, ItemFAQ o2) {
		if (o1.getDestaque() > o2.getDestaque()) {
			return -1;
		}else if (o1.getDestaque() < o2.getDestaque()) {
			return 1;
		}
		return 0;
	}

}
