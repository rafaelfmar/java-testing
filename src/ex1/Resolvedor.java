package ex1;

import java.util.ArrayList;

public class Resolvedor {
	private ClienteRepo repo;
	
	public Resolvedor(ClienteRepo repo) { this.repo = repo; }
	
	public ArrayList<Cliente> definirPromocao(int[] cods) throws Exception {
		
		if (/*1*/cods == null || /*2*/cods.length == 0)
			/*3*/throw new IllegalArgumentException("sem codigo");
		
		/*4*/var clientes = new ArrayList<Cliente>();
		
		for (/*5*/ int cod : cods) {
			
			/*6*/Cliente c = repo.getCliente(cod);
			
			if (/*7*/c == null)
				/*8*/throw new Exception("Codigo do cliente invalido");
			
			/*9*/clientes.add(c);
		}
		
		/*10*/var resposta = new ArrayList<Cliente>();
		
		if (/*11*/clientes.size() >= 3) {
			
			// todos ganham 20% de desconto
			for (/*12*/Cliente c : clientes) {
				
				/*13*/c.setDesconto(20);
				/*13*/resposta.add(c);
				
			}
			
		}
		else {
			
			// o 1º cliente ganha 10%
			/*14*/clientes.get(0).setDesconto(10);
			/*14*/resposta.add(clientes.get(0));
			
			//e, se existir, o 2º ganha 7%
			if (/*15*/clientes.size() > 1) {
				
				/*16*/clientes.get(1).setDesconto(7);
				/*16*/resposta.add(clientes.get(1));
				
			}
			
		}
		
		/*17*/return resposta;
	}
}
