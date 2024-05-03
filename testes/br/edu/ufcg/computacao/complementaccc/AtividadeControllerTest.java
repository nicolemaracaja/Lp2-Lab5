package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtividadeControllerTest {
	
	AtividadeController acBase;
	UsuarioController ucBase;

	@BeforeEach
	void setUp() throws Exception {
		this.ucBase = new UsuarioController();
		this.acBase = new AtividadeController(ucBase.getEstudantes());
		ucBase.criarEstudante("Nicole", "000.000.000-00", "00000000", "1231211413");
		ucBase.criarEstudante("Débora", "000.000.000-01", "00000001", "123111222");
		ucBase.criarEstudante("Nicolas", "000.000.000-02", "00000002", "123111333");		
	}

	/**
	 * CASO 1
	 * Criar monitoria com autenticação válida.
	 */
	@Test
	void testCriarAtividadeMonitoriaAutenticacaoValida() {
		assertEquals("000.000.000-00_1", acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2"));
	}

	/**
	 * CASO 2
	 * Criar monitoria com autenticação inválida.
	 */
	@Test
	void testCriarAtividadeMonitoriaAutenticacaoInalida() {
		try {
			acBase.criarAtividadeMonitoria("000.000.000-02", "00000000", "MONITORIA", 2, "LP2");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "AUTENTICAÇÃO FALHOU!");
		}
	}
	
	/**
	 * CASO 3
	 * Criar estágio com autenticação válida.
	 */
	@Test
	void testCriarAtividadeEstagioAutenticacaoValida() {
		assertEquals("000.000.000-01_1", acBase.criarAtividadeEstagio("000.000.000-01", "00000001", "ESTAGIO", 300, "CIRCUITOS"));
	}

	/**
	 * CASO 4
	 * Criar estágio com autenticação inválida.
	 */
	@Test
	void testCriarAtividadeEstagioAutenticacaoInvalida() {
		try {
			acBase.criarAtividadeEstagio("000.000.000-02", "00000000", "ESTAGIO", 120, "LP2");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "AUTENTICAÇÃO FALHOU!");
		}
	}
	
	/**
	 * CASO 5
	 * Criar pesquisa de extensão com autenticação válida.
	 */
	@Test
	void testCriarAtividadePesquisaExtensaoAutenticacaoValida() {
		assertEquals("000.000.000-00_1", acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "PESQUISA_EXTENSAO", 12, "-"));
	}

	/**
	 * CASO 6
	 * Criar pesquisa de extensão com autenticação inválida.
	 */
	@Test
	void testCriarAtividadePesquisaExtensaoAutenticacaoInvalida() {
		try {
			acBase.criarAtividadePesquisaExtensao("000.000.000-02", "00000000", "PESQUISA_EXTENSAO", 12, "-");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "AUTENTICAÇÃO FALHOU!");
		}
	}
	
	/**
	 * CASO 7
	 * Criar publicação com autenticação válida.
	 */
	@Test
	void testCriarAtividadePublicacaoAutenticacaoValida() {
		assertEquals("000.000.000-00_1", acBase.criarAtividadePublicacao("000.000.000-00", "00000000", "PUBLICACAO", 0, "TITULO", "*", "A3"));
	}
	
	/**
	 * CASO 8
	 * Criar publicação com autenticação inválida.
	 */
	@Test
	void testCriarAtividadePublicacaoAutenticacaoInvalida() {
		try {
			acBase.criarAtividadePublicacao("000.000.000-02", "00000000", "PUBLICACAO", 0, "TITULO", "*", "A3");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "AUTENTICAÇÃO FALHOU!");
		}
	}

	/**
	 * CASO 9
	 * Alterar descrição de uma atividade que existe no sistema.
	 */
	@Test
	void testAlterarDescricaoAtividadeExistente() {
		acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2");
		assertEquals(true, acBase.alterarDescricaoAtividade("000.000.000-00", "00000000", "000.000.000-00_1", "blablabla"));		
	}
	
	/**
	 * CASO 10
	 * Alterar descrição de uma atividade que não existe no sistema.
	 */
	@Test
	void testAlterarDescricaoAtividadeInxistente() {
		acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2");
		assertEquals(false, acBase.alterarDescricaoAtividade("000.000.000-00", "00000000", "000.000.000-00_2", "blablabla"));		
	}
	
	/**
	 * CASO 11
	 * Alterar comprovação de uma atividade que existe no sistema.
	 */
	@Test
	void testAlterarComprovacaoAtividadeExistente() {
		acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2");
		assertEquals(true, acBase.alterarComprovacaoAtividade("000.000.000-00", "00000000", "000.000.000-00_1", "blablabla"));	
	}
	
	/**
	 * CASO 12
	 * Alterar comprovação de uma atividade que não existe no sistema.
	 */
	@Test
	void testAlterarComprovacaoAtividadeInexistente() {
		acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2");
		assertEquals(false, acBase.alterarComprovacaoAtividade("000.000.000-00", "00000000", "000.000.000-00_2", "blablabla"));	
	}

	/**
	 * CASO 13
	 * Calcular créditos de uma monitoria que existe.
	 */
	@Test
	void testCalcularCreditosMonitoriaExistente() {
		acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "FMCC2");
		assertEquals(8, acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1"));
	}
	
	/**
	 * CASO 14
	 * Calcular créditos de uma monitoria que não existe.
	 */
	@Test
	void testCalcularCreditosMonitoriaInexistente() {
		try {
			acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CÓDIGO INVÁLIDO!");
		}
	}
	
	/**
	 * CASO 15
	 * Calcular créditos de um estágio que existe.
	 */
	@Test
	void testCalcularCreditosEstagioExistente() {
		acBase.criarAtividadeEstagio("000.000.000-01", "00000001", "ESTAGIO", 300, "-");
		assertEquals(5, acBase.calcularCreditos("000.000.000-01", "00000001", "000.000.000-01_1"));
		
		acBase.criarAtividadeEstagio("000.000.000-02", "00000002", "ESTAGIO", 50, "-");
		assertEquals(0, acBase.calcularCreditos("000.000.000-02", "00000002", "000.000.000-02_1"));
	}
	
	/**
	 * CASO 16
	 * Calcular créditos de um estágio que não existe.
	 */
	@Test
	void testCalcularCreditosEstagioInexistente() {
		try {
			acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CÓDIGO INVÁLIDO!");
		}
	}
	
	/**
	 * CASO 17
	 * Calcular créditos de uma pesquisa que existe.
	 */
	@Test
	void testCalcularCreditosPesquisaExtensãoExistente() {
		acBase.criarAtividadePesquisaExtensao("000.000.000-00", "00000000", "PESQUISA_EXTENSAO", 12, "-");
		assertEquals(10, acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1"));
		
		acBase.criarAtividadePesquisaExtensao("000.000.000-01", "00000001", "PESQUISA_EXTENSAO", 10, "-");
		assertEquals(0, acBase.calcularCreditos("000.000.000-01", "00000001", "000.000.000-01_1"));
	}
	
	/**
	 * CASO 18
	 * Calcular créditos de uma pesquisa que não existe.
	 */
	@Test
	void testCalcularCreditosPesquisaExtensãoInexistente() {
		try {
			acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CÓDIGO INVÁLIDO!");
		}
	}
	
	/**
	 * CASO 19
	 * Calcular créditos de uma publicação que existe
	 */
	@Test
	void testCalcularCreditosPublicacaoExistente() {
		acBase.criarAtividadePublicacao("000.000.000-00", "00000000", "PUBLICACAO", 0, "TITULO", "*", "A1");
		assertEquals(1, acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1"));
		
		acBase.criarAtividadePublicacao("000.000.000-01", "00000001", "PUBLICACAO_PERIODICO", 0, "TITULO", "*", "A2");
		assertEquals(4, acBase.calcularCreditos("000.000.000-01", "00000001", "000.000.000-01_1"));
		
		acBase.criarAtividadePublicacao("000.000.000-02", "00000002", "PUBLICACAO_CONFERENCIA", 0, "TITULO", "*", "A3");
		assertEquals(2, acBase.calcularCreditos("000.000.000-02", "00000002", "000.000.000-02_1"));
	}
	
	/**
	 * CASO 20
	 * Calcular créditos de uma publicação que não existe.
	 */
	@Test
	void testCalcularCreditosPublicacaoInexistente() {
		try {
			acBase.calcularCreditos("000.000.000-00", "00000000", "000.000.000-00_1");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CÓDIGO INVÁLIDO!");
		}
	}

}
