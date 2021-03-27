package ex2;

import java.util.ArrayList;

public class AClass {
	private Coder1 coder1;
	private Coder2 coder2;
	private Coder3 coder3;
	
	public AClass(Coder1 coder1, Coder2 coder2, Coder3 coder3) {
		this.coder1 = coder1;
		this.coder2 = coder2;
		this.coder3 = coder3;
	}
	
	public String cifrar(ArrayList<String> msg) {
		
		if (/*1*/msg == null || /*2*/msg.size() == 0 || /*3*/msg.contains("STOP"))
			/*4*/return "INVALID";
		
		if (/*5*/coder1.m1(msg) && /*6*/coder2.m2(msg))
			/*7*/return "C1-C2";
		
		
		/*8*/var count = 0;
		
		for (/*9*/String s : msg) {
			
			if (/*10*/s.equals("HI"))
				/*11*/count++;
			
		}
		
		if (/*12*/count >= 2)
			/*13*/return "2 OR MORE HIs";
		
		/*14*/int num = coder3.m3();
		
		if (/*15*/num > 1) {
			
			/*16*/String ret = "";
			
			for (/*16*/int i = 1; /*17*/i <= num; /*19*/i++)
				/*18*/ret += "-" + msg.get(0);
			
			/*20*/return ret;
		}
		
		
		/*21*/return msg.get(0);
	}

}
