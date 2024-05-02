package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para testar o FAQController.
 * @author Nicole Brito Maracajá - 123111413.
 */
class FAQControllerTest {
	
	private FAQController fcBase;
	private UsuarioController ucBase;

	@BeforeEach
	void setUp() throws Exception {
		this.ucBase = new UsuarioController();
		this.fcBase = new FAQController(ucBase.getAdmin());
	}

	/**
	 * CASO 1
	 * Verificar autenticação válida do admin.
	 */
	@Test
	void testAutenticacaoValida() {
		assertEquals(true, fcBase.autenticar("000.000.000-00", "00000000"));
	}
	
	/**
	 * CASO 2
	 * Verificar autenticação inválida do admin.
	 */
	@Test
	void testAutenticacaoInvalida() {
		assertEquals(false, fcBase.autenticar("000.000.000-00", "00000001"));
		
	}

	/**
	 * CASO 3
	 * Adicionar item ao FAQ com resposta.
	 */
	@Test
	void testAdicionarItemFAQComResposta() {
		assertEquals(true, fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble"));
	}

	/**
	 * CASO 4
	 * Adicionar item ao FAQ sem resposta.
	 */
	@Test
	void testAdicionarItemFAQSemResposta() {
		assertEquals(true, fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?"));
	}

	/**
	 * CASO 5
	 * Altera resposta de um item.
	 */
	@Test
	void testAlteraRespostaItem() {
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble");
		assertEquals(true, fcBase.alteraRespostaItem("000.000.000-00", "00000000", 0, "blu"));
	
	}

	/**
	 * CASO 6
	 * Destaca um item válido do FAQ.
	 */
	@Test
	void testDestacarItemIndiceValido() {
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble");
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "blu?");
		assertEquals(true, fcBase.destacarItem(0));
		assertEquals(true, fcBase.destacarItem(1));
	}
	
	/**
	 * CASO 7
	 * Destaca um item inválido do FAQ.
	 */
	@Test
	void destacarItemIndiceInvalido() {
		try {
			fcBase.destacarItem(2);
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ÍNDICE INVÁLIDO!");
		}
	}

	/**
	 * CASO 8
	 * Atribui tags a um item do FAQ.
	 */
	@Test
	void testAtribuirTagsItemFAQ() {
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble");
		List<String> novasTags = new ArrayList<>();
		novasTags.add("bla");
		novasTags.add("ble");
		assertEquals(true, fcBase.atribuirTagsItemFAQ("000.000.000-00", "00000000", 0, novasTags));	    
	}

	/**
	 * CASO 9
	 * Lista os itens da FAQ.
	 */
	@Test
	void testListarFAQ() {
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble");
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "blu?");
		
		String[] expected = {"bla? ble", "blu?"};
		String[] actual = fcBase.listarFAQ();

	    // Usa Arrays.toString para garantir que a comparação seja de valores, não de endereços de memória
	    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
	}

	/**
	 * CASO 10
	 * Lista os itens da FAQ por ordem de destaque.
	 */
	@Test
	void testListarFAQPorDestaque() {
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble");
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "blu?");
		fcBase.destacarItem(1);
		fcBase.destacarItem(1);
		fcBase.destacarItem(0);
		
		String[] expected = {"blu?", "bla? ble"};
		String[] actual = fcBase.listarFAQPorDestaque();
		
	    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
	}

	/**
	 * CASO 11
	 * Busca um item da FAQ a partir de tags.
	 */
	@Test
	void testBuscarItemFAQ() {
		List<String> tags = new ArrayList<>();
		tags.add("a");
		tags.add("b");
		String[] tagsBusca = {"a"};
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "bla?", "ble");
		fcBase.adicionarItemFAQ("000.000.000-00", "00000000", "blu?");
		fcBase.atribuirTagsItemFAQ("000.000.000-00", "00000000", 1, tags);
		
		String[] expected = {"blu?"};
		String[] actual = fcBase.buscarItemFAQ(tagsBusca);
		
	    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
	}

}
