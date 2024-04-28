package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para testar o ItemFAQ.
 * @author Nicole Brito Maracajá - 123111413.
 */
class ItemFAQTest {

	private ItemFAQ itemBase;
	
	@BeforeEach
	void setUp() throws Exception {
		this.itemBase = new ItemFAQ("blablabla?", "blebleble");
	}
	
	@Test
	void testGetPergunta() {
		assertEquals("blablabla?", itemBase.getPergunta());
	}

	@Test
	void testSetResposta() {
		itemBase.setResposta("bliblibli");
		assertEquals("bliblibli", itemBase.getResposta());
	}

	@Test
	void testIncrementarDestaque() {
		itemBase.incrementarDestaque();
		itemBase.incrementarDestaque();
		assertEquals(2, itemBase.getDestaque());
	}

	@Test
	void testGetDestaque() {
		assertEquals(0, itemBase.getDestaque());
	}

	@Test
	void testAdicionarTags() {
		List<String> novasTags = new ArrayList<>();
		novasTags.add("bla");
		novasTags.add("ble");
		itemBase.adicionarTags(novasTags);
	    List<String> tagsObtidas = itemBase.getTags();
	    
	    assertIterableEquals(novasTags, tagsObtidas);
	}

	@Test
	void testContemAlgumaTag() {
		List<String> novasTags = new ArrayList<>();
		novasTags.add("bla");
		novasTags.add("ble");
		novasTags.add("bli");
		itemBase.adicionarTags(novasTags);
		
		List<String> buscaTags = new ArrayList<>();
		buscaTags.add("bla");
		buscaTags.add("blu");
		
		assertEquals(true, itemBase.contemAlgumaTag(buscaTags));				
	}

	@Test
	void testToString() {
		assertEquals("blablabla? blebleble", itemBase.toString());
	}

}
