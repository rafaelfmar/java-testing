package ex5;

public class Mutante2 {
	public int calcularAnosBissexto(int ano[]) {
		int c = 0;
		for (int i = 0; i < ano.length; i++) {
			if(ano[i] % 400 == 0)
				c++;
			else if(ano[i] % 4 == 0 || ano[i] % 100 != 0)
				c++;
		}
		return c;
	}
}
