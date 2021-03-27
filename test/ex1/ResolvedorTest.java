package ex1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResolvedorTest {

	ClienteRepo clienteRepoMock;
	Resolvedor resolvedor;

	@BeforeEach
	void before() {
		clienteRepoMock = mock(ClienteRepo.class);
		resolvedor = new Resolvedor(clienteRepoMock);
	}

	// 1, 2
	@Test
	void testSemCodigo() {
		int[] cods = {};

		assertThrows(IllegalArgumentException.class, () -> {
			resolvedor.definirPromocao(cods);
		});
	}

	// 1, 2, 3
	@Test
	void testSemCodigo2() {
		assertThrows(IllegalArgumentException.class, () -> {
			resolvedor.definirPromocao(null);
		});
	}

	// 1, 2, 3, 4, 5, 6, 7, 8
	@Test
	void testCodigoClienteInvalido() {
		int[] cods = {1};

		when(clienteRepoMock.getCliente(1)).thenReturn(null);

		assertThrows(Exception.class, () -> {
			resolvedor.definirPromocao(cods);
		});
	}

	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 10, 11, 14, 15, 17
	@Test
	void test1Cliente() throws Exception {
		int[] cods = {1};

		when(clienteRepoMock.getCliente(1)).thenReturn(new Cliente(1, "Rafael"));

		assertEquals(1, resolvedor.definirPromocao(cods).size());
		assertEquals(10, resolvedor.definirPromocao(cods).get(0).getDesconto());
	}

	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 10, 11, 14, 15, 16, 17
	@Test
	void test2Clientes() throws Exception {
		int[] cods = {1, 2};

		when(clienteRepoMock.getCliente(1)).thenReturn(new Cliente(1, "Rafael"));
		when(clienteRepoMock.getCliente(2)).thenReturn(new Cliente(2, "Teste"));

		assertEquals(2, resolvedor.definirPromocao(cods).size());
		assertEquals(10, resolvedor.definirPromocao(cods).get(0).getDesconto());
		assertEquals(7, resolvedor.definirPromocao(cods).get(1).getDesconto());
	}

	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 10, 11, 12, 13, 12, 13, 12, 13, 12, 17
	@Test
	void test3Clientes() throws Exception {
		int[] cods = {1, 2, 3};

		when(clienteRepoMock.getCliente(1)).thenReturn(new Cliente(1, "Rafael"));
		when(clienteRepoMock.getCliente(2)).thenReturn(new Cliente(2, "Teste"));
		when(clienteRepoMock.getCliente(3)).thenReturn(new Cliente(3, "Teste 2"));

		assertEquals(3, resolvedor.definirPromocao(cods).size());
		assertEquals(20, resolvedor.definirPromocao(cods).get(0).getDesconto());
		assertEquals(20, resolvedor.definirPromocao(cods).get(1).getDesconto());
		assertEquals(20, resolvedor.definirPromocao(cods).get(2).getDesconto());
	}

}
