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
     * Pega a pergunta.
     * @return pergunta A pergunta do item.
     */
    public String getPergunta() {
        return this.pergunta;
    }
    
    /**
     * Pega a resposta.
     * @return resposta A resposta do item.
     */
    public String getResposta() {
    	return this.resposta;
    }

    /**
     * Muda a resposta do item.
     * @param resposta Nova resposta do item.
     */
    public void setResposta(String novaResposta) {
        this.resposta = novaResposta;
    }

    /**
     * Incrementa o destaque do item.
     */
    public void incrementarDestaque() {
        this.destaque++;
    }

    /**
     * Pega o destaque do item.
     * @return destaque O destaque do item.
     */
    public int getDestaque() {
        return this.destaque;
    }
    
    /**
     * Pega as tags do item
     * @return tags Tags do item.
     */
    public List<String> getTags() {
    	return this.tags;
    }

    /**
     * Adiciona tags ao item.
     * @param novasTags Tags que serão adicionadas.
     */
    public void adicionarTags(List<String> novasTags) {
        for (String tag : novasTags) {
            if (tags.size() < 3 && !tags.contains(tag)) {
                tags.add(tag);
            }
        }
    }

    /**
     * Verifica se o item contém alguma tag.
     * @param buscaTags Tags que serão verificadas.
     * @return true, se sim, se não, false.
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
     * Representação textual do item.
     * @return toString.
     */
    @Override
    public String toString() {
    	if(this.resposta == null) {
    		return this.pergunta;
    	}
        return this.pergunta + " " + this.resposta;
    }   
    
}
