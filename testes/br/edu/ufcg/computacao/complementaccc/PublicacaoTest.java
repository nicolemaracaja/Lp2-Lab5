package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa as funcionalidades de Publicação.
 * @author Nicole Brito Maracajá - 123111413.
 */
class PublicacaoTest {

	private Publicacao publicacaoBase;
	private Publicacao publicacaoBase2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.publicacaoBase = new Publicacao("PUBLICACAOO_PERIODICO", 0, "TITULO", "*", "A3");
		this.publicacaoBase2 = new Publicacao("PUBLICACAO_CONFERENCIA", 0, "TITULO", "*", "A1");
	}

	@Test
	void testCalcularCreditos() {
		assertEquals(3, publicacaoBase.calcularCreditos());
		assertEquals(1, publicacaoBase2.calcularCreditos());
	}

	@Test
	void testToString() {
		assertEquals("Publicação" + "\n" 
					+ "Título do artigo: TITULO" 
					+ "\n" + "DOI: *" + "\n" + "Qualis: A3", publicacaoBase.toString());
	}

}
