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


public class FogonTest {

	@Test
	
	public void testSolve(){
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
		
		Character[] exploradoras = {'a','b','c','d','e'};
	
		Fogon f = new Fogon();
		
		System.out.println(exploradoras.toString());
		
		System.out.println(f.solve(exploradoras, amistad).toString());
		
		amistad.removeAll(amistad);
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('a','c'));
		amistad.add(new Amistad('b','c'));
		amistad.add(new Amistad('b','e'));
		amistad.add(new Amistad('c','d'));
		amistad.add(new Amistad('d','a'));
		
		System.out.println(amistad.toString());
		System.out.println(f.solve(exploradoras, amistad).toString());
		
		return;
		
	}
	
	@Test
	
	public void pepe(){
		for (i=0;i<1000;i++){
			testSolve();
	
		}
	}
	
}