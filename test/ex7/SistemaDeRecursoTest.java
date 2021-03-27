package ex7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SistemaDeRecursoTest {

	@Test
	void testLogout() {
		// new()
		var sistemaDeRecurso = new SistemaDeRecurso();

		// loginValido / true
		assertTrue(sistemaDeRecurso.login("adm", "123"));

		// logout()
		sistemaDeRecurso.logout();

		// isLogado() / false
		assertFalse(sistemaDeRecurso.isLogado());

		// loginValido / true
		assertTrue(sistemaDeRecurso.login("adm", "123"));

		// acessar() / "REC1"
		assertEquals("REC1", sistemaDeRecurso.acessar());

		// acessar() / "REC2"
		assertEquals("REC2", sistemaDeRecurso.acessar());

		// logout()
		sistemaDeRecurso.logout();

		// isLogado() / false
		assertFalse(sistemaDeRecurso.isLogado());
	}

	@Test
	void testModificar() {
		// new()
		var sistemaDeRecurso = new SistemaDeRecurso();

		// modificar() / Exception
		assertThrows(RuntimeException.class, () -> {
			sistemaDeRecurso.modificar();
		});

		// loginValido / true
		assertTrue(sistemaDeRecurso.login("adm", "123"));

		// acessar() / "REC1"
		assertEquals("REC1", sistemaDeRecurso.acessar());

		// modificar() / "REC1 modificado"
		assertEquals("REC1 modificado", sistemaDeRecurso.modificar());

		// acessar() / "REC2"
		assertEquals("REC2", sistemaDeRecurso.acessar());

		// modificar() / "REC2 modificado"
		assertEquals("REC2 modificado", sistemaDeRecurso.modificar());
	}

	@Test
	void testTransicoesRestantes() {
		// new()
		var sistemaDeRecurso = new SistemaDeRecurso();

		// loginInvalido / false
		assertFalse(sistemaDeRecurso.login("adm", "1234"));

		// acessar() / Exception
		assertThrows(RuntimeException.class, () -> {
			sistemaDeRecurso.acessar();
		});

		// isLogado / false
		assertFalse(sistemaDeRecurso.isLogado());
	}

}
