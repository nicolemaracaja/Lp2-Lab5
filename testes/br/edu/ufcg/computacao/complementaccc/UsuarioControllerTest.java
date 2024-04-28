package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para testar o UsuarioController.
 * @author Nicole Brito Maracajá - 123111413.
 */
class UsuarioControllerTest {

	private UsuarioController ucBase;
	
	@BeforeEach
	void setUp() throws Exception {
		this.ucBase = new UsuarioController();
	}

	/**
	 * CASO 1
	 * criar estudante e verificar a validade da senha
	 */
	@Test
	void testCriarEstudanteSenhaValida() {
		assertEquals(true, ucBase.criarEstudante("Nicole", "000.000.000-01", "12345678", "123111413"));
	}
	
	/**
	 * CASO 2
	 * criar estudante e verificar a invalidade da senha
	 */
	@Test
	void testCriarEstudanteSenhaInvalida() {
		try {
			ucBase.criarEstudante("Nicole", "000.000.000-01", "12345", "123111413");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "SENHA INVÁLIDA!");
		}
	}

	/**
	 * CASO 3
	 * tentar criar estudante com cpf duplicado e verificar que não é possível
	 */
	@Test
	void testCriarEstudanteCpfDuplicado() {
		try {
			ucBase.criarEstudante("Nicole", "000.000.000-01", "12345678", "123111413");
			ucBase.criarEstudante("Joana", "000.000.000-01", "11111111", "123110200");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CPF JÁ CADASTRADO!");
		}
	}
	
	/**
	 * CASO 4
	 * verificar que a listagem dos estudantes só é possível se cpf/senha for de admin
	 */
	@Test
	void testExibirEstudantesSemCpfESenhaDeAdmin() {
		//admin inicial = "admin", "000.000.000-00", 000000000
		ucBase.criarEstudante("Nicole", "000.000.000-01", "12345678", "123111413");
		ucBase.criarEstudante("Joana", "000.000.000-02", "11111111", "123110200");
		ucBase.criarEstudante("Aline", "000.000.000-03", "22222222", "122000222");
		
		try {
			ucBase.exibirEstudantes("111.111.111-11", "11111111");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "FALHA NA AUTENTICAÇÃO!");
		}
	}
	
	/**
	 * CASO 5
	 * verificar listagem dos estudantes em ordem alfabética
	 */
	@Test
	void testExibirEstudantesEmOrdemAlfabetica() {
		//admin inicial = "admin", "000.000.000-00", 000000000
		ucBase.criarEstudante("Nicole", "000.000.000-01", "12345678", "123111413");
		ucBase.criarEstudante("Joana", "000.000.000-02", "11111111", "123110200");
		ucBase.criarEstudante("Aline", "000.000.000-03", "22222222", "122000222");
		
		String[] expected = {"Aline", "Joana", "Nicole"};
	    String[] actual = ucBase.exibirEstudantes("000.000.000-00", "00000000");

	    // Usa Arrays.toString para garantir que a comparação seja de valores, não de endereços de memória
	    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
	}

	/**
	 * CASO 6
	 * tentar alterar nome/senha do estudante com autenticação válida 
	 * (a senha passada como parâmetro é, de fato, a senha do estudante identificado pelo cpf passado)
	 */
	@Test
	void testAlterarEstudanteAutenticacaoValida() {
		ucBase.criarEstudante("Nicole", "000.000.000-01", "12345678", "123111413");
		assertEquals(true, ucBase.alterarEstudante("000.000.000-01", "12345678", "senha", "77777777"));		
	}
	
	/**
	 * CASO 7
	 * tentar alterar nome/senha do estudante com autenticação inválida 
	 * (a senha passada como parâmetro não é a senha do estudante identificado pelo cpf passado)
	 */
	@Test
	void testAlterarEstudanteAutenticacaoInvalida() {
		ucBase.criarEstudante("Nicole", "000.000.000-01", "12345678", "123111413");
		try {
			ucBase.alterarEstudante("000.000.000-01", "12345679", "senha", "77777777"); 
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "SENHA INVÁLIDA!");		
		}
	}

	/**
	 * CASO 8
	 * exibir o admin com autenticação válida
	 */
	@Test
	void testExibirAdminAutenticacaoValida() {
		//admin inicial = "admin", "000.000.000-00", 000000000
		assertEquals("Nome: admin" + "\n" + "CPF: 000.000.000-00", ucBase.exibirAdmin("000.000.000-00", "00000000"));
	}
	
	/**
	 * CASO 9
	 * tentar exibir o admin com autenticação inválida
	 */
	@Test
	void testExibirAdminAutenticacaoInvalida() {
		//admin inicial = "admin", "000.000.000-00", 000000000
		try {
			ucBase.exibirAdmin("000.000.000-00", "00000001");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "FALHA NA AUTENTICAÇÃO!");
		}
	}

	/**
	 * CASO 10
	 * configurar novo admin com autenticação válida
	 */
	@Test
	void testConfigurarNovoADMINAutenticacaoValida() {
		assertEquals(true, ucBase.configurarNovoADMIN("000.000.000-00", "00000000", "admin2", "000.000.000-11", "00000001"));
	}
	
	/**
	 * CASO 11
	 * tentar configurar novo admin com autenticação inválida
	 */
	@Test
	void testConfigurarNovoADMINAutenticacaoInvalida() {
		try {
			ucBase.configurarNovoADMIN("000.000.000-00", "00000001", "admin2", "000.000.000-11", "11111111");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "FALHA NA AUTENTICAÇÃO!");
		}
	}

	/**
	 * CASO 12
	 * configurar nova senha do admin com autenticação válida
	 */
	@Test
	void testConfigurarSenhaADMINAutenticacaoValida() {
		assertEquals(true, ucBase.configurarSenhaADMIN("000.000.000-00", "00000000", "11111111"));
	}
	
	/**
	 * CASO 13
	 * tentar configurar nova senha do admin com autenticação inválida
	 */
	@Test
	void testConfigurarSenhaADMINAutenticacaoInvalida() {
		try {
			ucBase.configurarSenhaADMIN("000.000.000-00", "00000001", "11111111");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "FALHA NA AUTENTICAÇÃO!");
		}
	}

	/**
	 * CASO 14
	 * retorna o admin do sistema
	 */
	@Test
	void testGetAdmin() {
		ucBase.configurarNovoADMIN("000.000.000-00", "00000000", "Nicole", "111.222.333-44", "12345678");
		assertEquals(ucBase.getAdmin().toString(), "Nome: Nicole" + "\n" + "CPF: 111.222.333-44");
	}

}
