package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe ItemFAQ, que representa o conjunto pergunta + resposta do FAQ.
 */
public class ItemFAQ {

	/**
	 * Pergunta do item.
	 */
	private String pergunta;
	
	/**
	 * Resposta do item.
	 */
    private String resposta;
    
    /**
     * Popularidade do item.
     */
    private int destaque;
    
    /**
     * Tags que o item possui.
     */
    private List<String> tags;

    /**
     * Constrói o ItemFAQ, a partir de uma pergunta e uma resposta.
     * @param pergunta pergunta do item.
     * @param resposta Resposta do item.
     */
    public ItemFAQ(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.destaque = 0; // Inicialmente, o destaque é zero
        this.tags = new ArrayList<>();
    }

    /**
     * 
     * @return
     */
    public String getPergunta() {
        return this.pergunta;
    }

    /**
     * 
     * @param resposta
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * 
     */
    public void incrementarDestaque() {
        this.destaque++;
    }

    /**
     * 
     * @return
     */
    public int getDestaque() {
        return this.destaque;
    }

    /**
     * 
     * @param novasTags
     */
    public void adicionarTags(String[] novasTags) {
        for (String tag : novasTags) {
            if (tags.size() < 3 && !tags.contains(tag)) {
                tags.add(tag);
            }
        }
    }

    /**
     * 
     * @param buscaTags
     * @return
     */
    public boolean contemAlgumaTag(List<String> buscaTags) {
        for (String tag : tags) {
            if (buscaTags.contains(tag)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "Pergunta: " + pergunta + ", Resposta: " + resposta + ", Destaque: " + destaque + ", Tags: " + tags;
    }
}
