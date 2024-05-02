package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa as funcionalidades da Monitoria.
 * @author Nicole Brito Maracajá - 123111413.
 */
class MonitoriaTest {

	private Monitoria monitoriaBase;
	private Monitoria monitoriaBase2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.monitoriaBase = new Monitoria("MONITORIA", 2, "FMCC2");
		this.monitoriaBase2 = new Monitoria("MONITORIA", 5, "LP2");
	}

	@Test
	void testCalcularCreditos() {
		assertEquals(8, monitoriaBase.calcularCreditos());
		assertEquals(16, monitoriaBase2.calcularCreditos());
	}

	@Test
	void testToString() {
		assertEquals("Monitoria" + "\n" 
					+ "Disciplina: FMCC2" , monitoriaBase.toString());
	}

}
