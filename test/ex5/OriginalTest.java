package ex5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OriginalTest {

	Original original;

	@BeforeEach
	void before() {
		original = new Original();
	}

	@Test
	void testMutante1() {
		var mutante = new Mutante1();
		int anos[] = { 2016, 2017, 2018, 2019, 2020 };

		assertEquals(2, original.calcularAnosBissexto(anos));
		assertEquals(2, mutante.calcularAnosBissexto(anos));
	}


	@Test
	void testMutante2() {
		var mutante = new Mutante2();
		int anos[] = { 2016, 2017, 2018, 2019, 2020 };

		assertEquals(2, original.calcularAnosBissexto(anos));
		assertEquals(2, mutante.calcularAnosBissexto(anos));
	}


	@Test
	void testMutante3() {
		var mutante = new Mutante3();
		int anos[] = { 2000, 2016, 2017, 2018, 2019, 2020 };

		assertEquals(3, original.calcularAnosBissexto(anos));
		assertEquals(3, mutante.calcularAnosBissexto(anos));

		// Equivalente. Anos com resto da divisao == 0 quando divididos por 400 tambem sao divisiveis por 40
	}

}
