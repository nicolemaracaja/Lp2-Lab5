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
    public Publicacao(String codigo, String tipo, String descricao, String linkComprovacao, String tituloArtigo, String doi, String qualis) {
        super(codigo, tipo, descricao, linkComprovacao);
        this.tituloArtigo = tituloArtigo;
        this.doi = doi;
        this.qualis = qualis;
    }

    /**
     * Calcula a quantidade de créditos acumulados pelo usuário, não podendo ultrapassar 16 créditos.
     */
    @Override
    public int calcularCreditos() {
        return 2; //uma publicação em conferência Qualis A3 iria gerar 2 créditos
    }
    
    /**
     * Representação textual da atividade Publicação.
     */
    @Override
    public String toString() {
    	return super.toString() + "\n" + "Título do artigo: " + this.tituloArtigo + "\n" + "DOI: " + this.doi + "\n" + "Qualis: " + this.qualis;
    }
}
