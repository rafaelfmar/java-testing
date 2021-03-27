package ex4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutenticacaoTest {

	Autenticacao autenticacao;

	@BeforeEach
	void before() {
		autenticacao = new Autenticacao();
	}

	@Test
	void testC1() {
		var mensagemEsperada = "e-mail/senha não podem ser vazio";
		var usuario = new Usuario("", "abcd", null);

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC2() {
		var mensagemEsperada = "e-mail/senha não podem ser vazio";
		var usuario = new Usuario("teste@mail.com", "", null);

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC3() {
		var mensagemEsperada = "e-mail fora do formato";
		var usuario = new Usuario("teste.com", "abcd", null);

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC4() {
		var mensagemEsperada = "usuario não existe";
		var usuario = new Usuario("usuario@inexistente.com", "abcd", null);

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC5() {
		var mensagemEsperada = "a senha tem ao menos 4 caracteres";
		var usuario = new Usuario("teste@mail.com", "123", null);

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC6() {
		var mensagemEsperada = "senha incorreta";
		var usuario = new Usuario("teste@mail.com", "1234", null);

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC7() {
		var mensagemEsperada = "logado como admin";
		var usuario = new Usuario("teste@mail.com", "abcd", "admin");

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

	@Test
	void testC8() {
		var mensagemEsperada = "logado";
		var usuario = new Usuario("teste@mail.com", "abcd", "normal");

		assertEquals(mensagemEsperada, autenticacao.login(usuario));
	}

}
