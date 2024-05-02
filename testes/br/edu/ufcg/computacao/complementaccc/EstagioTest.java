package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa as funcionalidades de Estágio.
 * @author Nicole Brito Maracajá - 123111413.
 */
class EstagioTest {

	private Estagio estagioBase;
	private Estagio estagioBase2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.estagioBase = new Estagio("ESTÁGIO", 150, "-");
		this.estagioBase2 = new Estagio("ESTÁGIO", 360, "-");
	}

	@Test
	void testCalcularCreditos() {
		assertEquals(2, estagioBase.calcularCreditos());
		assertEquals(6, estagioBase2.calcularCreditos());
	}

	@Test
	void testToString() {
		assertEquals("Estágio" + "\n" 
					+ "Horas: 150" , estagioBase.toString());
	}

}
