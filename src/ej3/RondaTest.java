package ej3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Test;


public class RondaTest {


	@Test 	
	public void distancia(){
		
		Ronda r = new Ronda(Utils.parseArrayList( "a b c d e"));
		System.out.println(r.toString());
		System.out.println(r.size());
		
		assertEquals(1,r.distancia(0, 1));
		assertEquals(2,r.distancia(0, 2));
		assertEquals(2,r.distancia(0, 3));
		assertEquals(1,r.distancia(0, 4));
		assertEquals(0,r.distancia(0, 5));
		
		assertEquals(1,r.distancia(1, 2));
		assertEquals(2,r.distancia(1, 3));
		assertEquals(2,r.distancia(1, 4));
		assertEquals(1,r.distancia(1, 5));
		assertEquals(1,r.distancia(1, 0));
		
		//Seguir todos contra todos...�?
	}
	
	@Test 
	   public void distanciaMaxTestBasico() {
		
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		
		//Prueba 1(un caso facil):
		
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('a','c'));
		amistad.add(new Amistad('b','c'));
		 
		Ronda r = new Ronda(Utils.parseArrayList( "a b c"));
			 
		System.out.println(Utils.parseArrayList( "a b c "));
		System.out.println(amistad.toString());

	//	assertEquals(r.distanciaMax(amistad),1);
		
		System.out.println("Ok...");
		
		//Prueba 2(catedra):
		
		amistad.removeAll(amistad);
		assertEquals(amistad.size(),0);
		amistad.add(new Amistad('a','b')); 
		amistad.add(new Amistad('a','c')); 
		amistad.add(new Amistad('a','d')); 
		amistad.add(new Amistad('a','e')); 
		amistad.add(new Amistad('b','c')); 
		amistad.add(new Amistad('b','d')); 
		amistad.add(new Amistad('b','e')); 
		amistad.add(new Amistad('c','d')); 
		amistad.add(new Amistad('c','e')); 
		
		Ronda r2 = new Ronda(Utils.parseArrayList( "a b c d e "));
		System.out.println(r2.toString());
		System.out.println(amistad.toString());
		System.out.println(r2.distanciaMaxima(amistad));
		
		//assertEquals(2,r2.distanciaMax(amistad));
		
		//Prueba 3(catedra):
		amistad.removeAll(amistad);
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('a','c'));
		amistad.add(new Amistad('b','c'));
		amistad.add(new Amistad('b','e'));
		amistad.add(new Amistad('c','d'));
		amistad.add(new Amistad('d','a'));
		
		Ronda r3 = new Ronda(Utils.parseArrayList( "a b e c d "));
		System.out.println(r2.toString());
		System.out.println(amistad.toString());
	
		//assertEquals(2,r3.distanciaMax(amistad));
		
		//Prueba 3(catedra):
			amistad.removeAll(amistad);
			amistad.add(new Amistad('a','b'));
			amistad.add(new Amistad('a','f'));
			amistad.add(new Amistad('b','c'));
			amistad.add(new Amistad('b','g'));
			amistad.add(new Amistad('d','g'));
			amistad.add(new Amistad('d','c'));
			amistad.add(new Amistad('f','g'));
			amistad.add(new Amistad('f','h'));
			amistad.add(new Amistad('e','h'));
			amistad.add(new Amistad('e','d'));
			

			Ronda r4 = new Ronda(Utils.parseArrayList( "a b e c d e f g h"));
			System.out.println(r4.toString());
			System.out.println(amistad.toString());
		
		//	assertEquals(3,r4.distanciaMax(amistad));
		
			
			System.out.println("Listo, todo peola");
		
		 
		 
		 
	    	      
	   }
}
