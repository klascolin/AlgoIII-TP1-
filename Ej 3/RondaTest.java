package uba.algo3.ejemplotp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Test;

import uba.algo3.Utils;


public class RondaTest {

	 @Test 
	   public void distanciaMaxTestBasico() {
		
		 HashSet<Amistad> amistad = new HashSet<Amistad>();
		 amistad.add(new Amistad('a','b'));
		 amistad.add(new Amistad('a','c'));
		 amistad.add(new Amistad('b','c'));
		 
		 Ronda r = new Ronda(Utils.parseArrayList( "a b c"));
			 
		System.out.println(Utils.parseArrayList( "a b c "));
		System.out.println(amistad.toString());

		
		//Prueba 1:
		assertEquals(r.distanciaMax(amistad),1);
		
		
		//Prueba 2:
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('a','c'));
		amistad.add(new Amistad('b','c'));
		amistad.add(new Amistad('b','e'));
		amistad.add(new Amistad('c','d'));
		amistad.add(new Amistad('d','a'));
		
		Ronda r2 = new Ronda(Utils.parseArrayList( "a b c d e "));
		System.out.println(r2.toString());
		System.out.println(amistad.toString());
		
		
		assertEquals(2,r2.distanciaMax(amistad));
		
		
		 
		 
		 
	    	      
	   }
}
