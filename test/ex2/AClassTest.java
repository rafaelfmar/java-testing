package ex2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AClassTest {

	Coder1 coder1Mock;
	Coder2 coder2Mock;
	Coder3 coder3Mock;
	AClass aClass;

	@BeforeEach
	void before() {
		coder1Mock = mock(Coder1.class);
		coder2Mock = mock(Coder2.class);
		coder3Mock = mock(Coder3.class);
		aClass = new AClass(coder1Mock, coder2Mock, coder3Mock);
	}

	// 1, 4
	@Test
	void testInvalid() {
		assertEquals("INVALID", aClass.cifrar(null));
	}

	// 1, 2, 4
	@Test
	void testInvalid2() {
		ArrayList<String> msg = new ArrayList<String>();

		assertEquals("INVALID", aClass.cifrar(msg));
	}

	// 1, 2, 3, 4
	@Test
	void testInvalid3() {
		ArrayList<String> msg = new ArrayList<String>(Arrays.asList("STOP"));

		assertEquals("INVALID", aClass.cifrar(msg));
	}

	// 1, 2, 3, 4, 5, 6, 7
	@Test
	void testC1C2() {
		ArrayList<String> msg = new ArrayList<String>(Arrays.asList("C1-C2"));

		when(coder1Mock.m1(msg)).thenReturn(true);
		when(coder2Mock.m2(msg)).thenReturn(true);

		assertEquals("C1-C2", aClass.cifrar(msg));
	}

	// 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 9, 10, 11, 9, 12, 13
	@Test
	void test2HIs() {
		ArrayList<String> msg = new ArrayList<String>(Arrays.asList("HI", "HI"));

		when(coder1Mock.m1(msg)).thenReturn(true);
		when(coder2Mock.m2(msg)).thenReturn(false);

		assertEquals("2 OR MORE HIs", aClass.cifrar(msg));
	}

	// 1, 2, 3, 4, 5, 8, 9, 10, 9, 12, 14, 15, 21
	@Test
	void testSucesso() {
		ArrayList<String> msg = new ArrayList<String>(Arrays.asList("abc"));

		when(coder1Mock.m1(msg)).thenReturn(false);
		when(coder3Mock.m3()).thenReturn(1);

		assertEquals("abc", aClass.cifrar(msg));
	}

	// 1, 2, 3, 4, 5, 8, 9, 10, 9, 12, 14, 15, 16, 17, 18, 19, 17, 18, 19, 17, 20
	@Test
	void testSucesso2() {
		ArrayList<String> msg = new ArrayList<String>(Arrays.asList("abc", "123"));

		when(coder1Mock.m1(msg)).thenReturn(false);
		when(coder3Mock.m3()).thenReturn(2);

		assertEquals("-abc-abc", aClass.cifrar(msg));
	}

}
