package ex3;

public interface CartorioEleitoral {
	/** Esse m�todo pode retornar:
	 * - "nao existe": se o cpf n�o possui titulo associado
	 * - "pendencia": o titulo possui alguma pendencia
	 * - "OK": situacao regularizada para o t�tulo */
	public String verificar(String cpf);
}
