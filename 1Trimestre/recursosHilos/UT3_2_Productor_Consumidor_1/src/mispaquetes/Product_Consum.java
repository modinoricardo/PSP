package mispaquetes;

public class Product_Consum {
	  public static void main(String[] args) {  
	    Cola cola = new Cola();
		
	    Productor p = new Productor(cola, 1);	
	    Productor p2 = new Productor(cola, 2);
		Consumidor c = new Consumidor(cola, 1);
		
	    p.start();
	    p2.start();
		c.start();

	  }
	}