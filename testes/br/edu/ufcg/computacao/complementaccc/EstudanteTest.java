package br.edu.ufcg.computacao.complementaccc;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para testar o Estudante.
 * @author Nicole Brito Maracajá - 123111413.
 */
class EstudanteTest {

	private Estudante estudanteBase;
	
	@BeforeEach
	void setUp() throws Exception {
		this.estudanteBase = new Estudante("Nicole", "000.000.000-00", "12345678", "123111413");
	}

	@Test
	void testToString() {
		assertEquals("Nome: Nicole"
				+ "\n" + "CPF: 000.000.000-00"
				+ "\n" + "Matrícula: 123111413", estudanteBase.toString());
	}

	@Test
	void testGetMatricula() {
		assertEquals("123111413", estudanteBase.getMatricula());
	}

	@Test
	void testSetMatricula() {
		estudanteBase.setMatricula("120111274");
		assertEquals("120111274", estudanteBase.getMatricula());
	}
}
