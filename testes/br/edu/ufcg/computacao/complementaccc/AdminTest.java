package br.edu.ufcg.computacao.complementaccc;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para testar o Admin.
 * @author Nicole Brito Maracajá - 123111413.
 */
class AdminTest {

	private Admin adminBase;
	
	@BeforeEach
	void setUp() throws Exception {
		this.adminBase = new Admin("Nicole", "000.000.000-00", "12345678");
	}

	@Test
	void testToString() {
		assertEquals("Nome: Nicole"
				+ "\n" + "CPF: 000.000.000-00", adminBase.toString());
	}

	@Test
	void testReconfigurar() {
		adminBase.reconfigurar("José", "111.222.333-44", "77777777");
		assertEquals("Nome: José"
				+ "\n" + "CPF: 111.222.333-44", adminBase.toString());
	}

}
