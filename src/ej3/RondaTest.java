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
	public void testDistancia(){
		
		Ronda r = new Ronda(Utils.parseArrayList( "a b c d e"));
		
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
		
		//Seguir todos contra todos...
	}
	
	@Test 
	public void minimizacionTestA() {
		System.out.println("TestA(un caso basico)...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
	
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('a','c'));
		amistad.add(new Amistad('b','c'));
		 
		Ronda r = new Ronda(Utils.parseArrayList( "a b c"));
			 
		assertEquals(1,r.distanciaMaxima(amistad));
		assertEquals(3,r.sumaDistancias(amistad));
		
		System.out.println("Ok...");
		return;
	}	
		
	@Test
	
	public void minimizacionTestB() {
		System.out.println("TestB(casos mas generales)...");
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		
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
		assertEquals(2,r2.distanciaMaxima(amistad));
		assertEquals(14,r2.sumaDistancias(amistad));
		
		Ronda r3 = new Ronda(Utils.parseArrayList( "a b d c e "));
		assertEquals(2,r3.distanciaMaxima(amistad));
		assertEquals(13,r3.sumaDistancias(amistad));
		
		Ronda r4 = new Ronda(Utils.parseArrayList( "d e a b c "));
		assertEquals(14,r4.sumaDistancias(amistad));
		assertEquals(2,r4.distanciaMaxima(amistad));
		
		Ronda r5 = new Ronda(Utils.parseArrayList( "b c d e a "));
		assertEquals(2,r5.distanciaMaxima(amistad));
		assertEquals(14,r5.sumaDistancias(amistad));
		

		System.out.println("Ok...");
		
		return;			
	}
	
	@Test 
	public void minimizacionTestBorder(){
		
		//Algun otro???
		System.out.println("TestBorder...");
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		
		Ronda r1 = new Ronda(Utils.parseArrayList( "a b c d e "));
		assertEquals(0,r1.distanciaMaxima(amistad));
		assertEquals(0,r1.sumaDistancias(amistad));
		
		Ronda r2 = new Ronda(Utils.parseArrayList( " "));
		assertEquals(0,r2.distanciaMaxima(amistad));
		assertEquals(0,r2.sumaDistancias(amistad));
		
		Ronda r3 = new Ronda(Utils.parseArrayList( "a"));
		assertEquals(0,r3.distanciaMaxima(amistad));
		assertEquals(0,r3.sumaDistancias(amistad));	
		
		System.out.println("Ok...");
		return;
	}
}
