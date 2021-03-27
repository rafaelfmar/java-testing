package ex7;

public class SistemaDeRecurso {
	private boolean logado = false;
	private int rec = 0;

	public boolean login(String usuario, String senha) {
		if(usuario.equals("adm") && senha.equals("123"))
			logado = true;
		return logado;
	}

	public void logout() {
		logado = false;
		rec = 0;
	}
	
	public boolean isLogado() { return logado; }

	public String acessar() {
		if(! logado)
			throw new RuntimeException("nao pode acessar");
		return "REC" + (++rec);
	}

	public String modificar() {
		if(! logado)
			throw new RuntimeException("nao pode modificar");

		return "REC" + rec + " modificado";
	} 
}
