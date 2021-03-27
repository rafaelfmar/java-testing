package ex3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerificadorEleitoralTest {

	VerificadorEleitoral verificador;
	CartorioEleitoral cartorioMock;

	@BeforeEach
	void before() {
		cartorioMock = mock(CartorioEleitoral.class); 
		verificador = new VerificadorEleitoral(cartorioMock);
	}

	// ( (0, 12345678910); exception)
	@Test
	void testIdadeInvalida() {
		var idade = 0;
		var cpf = "12345678910";

		assertThrows(Exception.class, () -> {
			verificador.consultarSituacao(idade, cpf);
		});
	}
	
	// ( (200, 12345678910); exception)
	@Test
	void testIdadeInvalida2() {
		var idade = 200;
		var cpf = "12345678910";

		assertThrows(Exception.class, () -> {
			verificador.consultarSituacao(idade, cpf);
		});
	}

	// ( (18, 1234567890); exception)
	@Test
	void testCpfInvalido() {
		var idade = 18;
		var cpf = "1234567890";

		assertThrows(Exception.class, () -> {
			verificador.consultarSituacao(idade, cpf);
		});
	}

	// ( (18, abcde); exception)
	@Test
	void testCpfInvalido2() {
		var idade = 18;
		var cpf = "abcde";

		assertThrows(Exception.class, () -> {
			verificador.consultarSituacao(idade, cpf);
		});
	}

	// ( (18, 12345678910); “voto obrigatorio”)
	@Test
	void testSucesso() throws Exception {
		var idade = 18;
		var cpf = "12345678910";

		when(cartorioMock.verificar(cpf)).thenReturn("OK");

		assertEquals("voto obrigatorio", verificador.consultarSituacao(idade, cpf));
	}

	/*
	 * 
	 * Valores limites
	 * 
	 * */

	// ( (1, 12345678910); “nao pode votar”)
	@Test
	void testNaoPodeVotar1() throws Exception {
		var idade = 1;
		var cpf = "12345678910";

		assertEquals("nao pode votar", verificador.consultarSituacao(idade, cpf));
	}

	// ( (2, 12345678910); “nao pode votar”)
	@Test
	void testNaoPodeVotar2() throws Exception {
		var idade = 2;
		var cpf = "12345678910";

		assertEquals("nao pode votar", verificador.consultarSituacao(idade, cpf));
	}

	// ( (198, 12345678910); “voto facultativo”)
	@Test
	void testVotoFacultativo() throws Exception {
		var idade = 198;
		var cpf = "12345678910";

		when(cartorioMock.verificar(cpf)).thenReturn("OK");

		assertEquals("voto facultativo", verificador.consultarSituacao(idade, cpf));
	}


	// ( (199, 12345678910); “voto facultativo”)
	@Test
	void testVotoFacultativo2() throws Exception {
		var idade = 199;
		var cpf = "12345678910";

		when(cartorioMock.verificar(cpf)).thenReturn("OK");

		assertEquals("voto facultativo", verificador.consultarSituacao(idade, cpf));
	}

	// ( (18, 123456789100); exception)
	@Test
	void testCpfInvalido3() throws Exception {
		var idade = 18;
		var cpf = "123456789100";

		assertThrows(Exception.class, () -> {
			verificador.consultarSituacao(idade, cpf);
		});
	}
}
