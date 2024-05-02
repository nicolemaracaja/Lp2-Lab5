package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa as funcionalidades de Pesquisa de Extensão.
 * @author Nicole Brito Maracajá - 123111413.
 */
class PesquisaExtensaoTest {

	private PesquisaExtensao pesquisaBase;
	private PesquisaExtensao pesquisaBase2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.pesquisaBase = new PesquisaExtensao("PESQUISA", 10, "-");
		this.pesquisaBase2 = new PesquisaExtensao("PESQUISA", 22, "-");
	}

	@Test
	void testCalcularCreditos() {
		assertEquals(0, pesquisaBase.calcularCreditos());
		assertEquals(10, pesquisaBase2.calcularCreditos());
	}

	@Test
	void testToString() {
		assertEquals("Pesquisa de Extensão" + "\n" 
					+ "Quantidade de meses: 10" , pesquisaBase.toString());
	}

}
