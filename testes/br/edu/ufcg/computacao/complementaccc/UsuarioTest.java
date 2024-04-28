package br.edu.ufcg.computacao.complementaccc;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para testar o Usuário.
 * @author Nicole Brito Maracajá - 123111413.
 */
class UsuarioTest {

	private Usuario usuarioBase;
	
	@BeforeEach
	void setUp() throws Exception {
		this.usuarioBase = new Usuario("Nicole", "000.000.000-00", "12345678");
	}
	
	@Test
	void testGetNome() {
		assertEquals("Nicole", usuarioBase.getNome());
	}

	@Test
	void testSetNome() {
		usuarioBase.setNome("Nick");
		assertEquals("Nick", usuarioBase.getNome());
	}

	@Test
	void testGetCpf() {
		assertEquals("000.000.000-00", usuarioBase.getCpf());
	}

	@Test
	void testGetSenha() {
		assertEquals("12345678", usuarioBase.getSenha());
	}

	@Test
	void testSetSenha() {
		usuarioBase.setSenha("00000000");
		assertEquals("00000000", usuarioBase.getSenha());
	}

	@Test
	void testAutenticar() {
		assertEquals(true, usuarioBase.autenticar("12345678"));
		assertEquals(false, usuarioBase.autenticar("00000000"));
	}

	@Test
	void testEqualsObject() {
		Usuario outroUsuario = new Usuario("Aline", "000.000.000-00", "11111111");
		Usuario novoUsuario = new Usuario("Nicolas", "123.456.789-00", "00000000");
		
		assertEquals(true, usuarioBase.equals(outroUsuario));
		assertEquals(false, usuarioBase.equals(novoUsuario));
	}

	@Test
	void testToString() {
		assertEquals("Nome: Nicole"
				+ "\n" + "CPF: 000.000.000-00", usuarioBase.toString());
	}

}
