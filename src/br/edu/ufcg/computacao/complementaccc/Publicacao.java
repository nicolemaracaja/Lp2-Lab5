package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe Publicação, que possui herança de Atividade.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class Publicacao extends Atividade {
	
	/**
	 * Título do artigo.
	 */
    private String tituloArtigo;
    
    /**
     * DOI (Digital Object Identifier).
     */
    private String doi;
    
    /**
     * Qualis.
     */
    private String qualis;

    /**
     * Constrói a Publicação.
     * @param codigo Código da atividade.
     * @param tipo Tipo da atividade.
     * @param descricao Descrição da atividade.
     * @param linkComprovacao Link do documento comprobatório da publicação.
     * @param tituloArtigo Título do artigo da publicação.
     * @param doi DOI.
     * @param qualis Qualis.
     */
    public Publicacao(String tipo, int unidadeAcumulada, String tituloArtigo, String doi, String qualis) {
        super(tipo, unidadeAcumulada);
        if (tituloArtigo.isBlank() || tituloArtigo.trim().isEmpty()) {
            throw new IllegalArgumentException("TÍTULO DO ARTIGO INVÁLIDO!");
        }
        if (doi.isBlank() || doi.trim().isEmpty()) {
            throw new IllegalArgumentException("DOI INVÁLIDO!");
        }
        if (qualis.isBlank() || qualis.trim().isEmpty()) {
            throw new IllegalArgumentException("QUALIS INVÁLIDO!");
        }
        this.unidadeAcumulada = 0;
        this.tituloArtigo = tituloArtigo;
        this.doi = doi;
        this.qualis = qualis;
    }

    /**
     * Calcula a quantidade de créditos acumulados pelo usuário, não podendo ultrapassar 16 créditos.
     */
    @Override
    public int calcularCreditos() {
    	if (tipo.contentEquals("PUBLICACAO PERIODICO") && qualis.equals("A1")) {
    		return 4;
    	}else if (tipo.contentEquals("PUBLICACAO PERIODICO") && qualis.equals("A2")) {
    		return 4;
    	}else if (tipo.contentEquals("PUBLICACAO PERIODICO") && qualis.equals("A3")) {
    		return 3;
    	}else if (tipo.contentEquals("PUBLICACAO CONFERENCIA") && qualis.equals("A1")) {
    		return 1;
    	}else if (tipo.contentEquals("PUBLICACAO CONFERENCIA") && qualis.equals("A2")) {
    		return 3;
    	}else if (tipo.contentEquals("PUBLICACAO CONFERENCIA") && qualis.equals("A3")) {
    		return 2;
    	}else {
    		return 1;
    	}
    }
    
    /**
     * Representação textual da atividade Publicação.
     */
    @Override
    public String toString() {
    	return "Publicação" + "\n" + "Título do artigo: " + this.tituloArtigo + "\n" + "DOI: " + this.doi + "\n" + "Qualis: " + this.qualis;
    }
}
