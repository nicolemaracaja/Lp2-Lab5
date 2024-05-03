package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa as funcionalidades de RelatorioController.
 * @author Nicole Brito Maracajá - 123111413.
 */
class RelatorioControllerTest {

	private RelatorioController rcBase;
	private UsuarioController ucBase;
	private AtividadeController acBase;
	
	@BeforeEach
	void setUp() throws Exception {
		this.ucBase = new UsuarioController();
		this.rcBase = new RelatorioController(ucBase);
		this.acBase = new AtividadeController(ucBase.getEstudantes());
		ucBase.criarEstudante("Nicole", "000.000.000-00", "00000000", "123111413");
		acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2");
	}

	@Test
	void testCriarRelatorioCompleto() {
		assertEquals(1, rcBase.criarRelatorioCompleto("000.000.000-00", "00000000"));
	}

	@Test
	void testCriarRelatorioResumido() {
		assertEquals(1, rcBase.criarRelatorioResumido("000.000.000-00", "00000000"));
	}

	@Test
	void testCriarRelatorioPorATV() {
		assertEquals(1, rcBase.criarRelatorioPorATV("000.000.000-00", "00000000", "MONITORIA"));
	}

	@Test
	void testExibirRelatorio() {
		
	}

}
