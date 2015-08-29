package ej3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;

import org.junit.Test;


public class FogonTest {

	@Test	
	public void testSolve1(){
		System.out.println("Test1...");
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
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		String r1 = "[a, b, d, c, e] 2";
		
		Ronda optima = f.solve(exploradoras,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		
	
		System.out.println("Ok...");
		
	}
	
	@Test
	public void testSolve2(){
		System.out.println("Test2...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'a','b','c','d','e'};

		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('a','c'));
		amistad.add(new Amistad('b','c'));
		amistad.add(new Amistad('b','e'));
		amistad.add(new Amistad('c','d'));
		amistad.add(new Amistad('d','a'));
		
		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());

		String s = "[a, b, e, c, d] 2";
		Ronda optima = f.solve(exploradoras,amistad); 
		
		assertEquals(s,optima.toString() + " " + optima.distanciaMaxima(amistad));
		
		System.out.println("Ok...");
		
		
}
	

	
	@Test
	public void testSolve3(){
		System.out.println("Test3...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'a','b','c','d','e', 'f', 'g', 'h'};

		amistad.add(new Amistad('a','f'));
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('b','g'));
		amistad.add(new Amistad('b','c'));		
		amistad.add(new Amistad('d','g'));
		amistad.add(new Amistad('d','c'));
		amistad.add(new Amistad('f','a'));
		amistad.add(new Amistad('f','g'));
		amistad.add(new Amistad('f','h'));
		amistad.add(new Amistad('e','h'));
		amistad.add(new Amistad('e','d'));

		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		String  r1 = "[a, b, g, c, d, e, h, f] 3";
		
		Ronda optima = f.solve(exploradoras,amistad); 
		
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		System.out.println(optima.toString() + " " + optima.distanciaMaxima(amistad));
		//System.out.println("Ok...");
		
}
	


	@Test
	public void testSolve4(){
		System.out.println("Test4...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'x','y','z'};

		amistad.add(new Amistad('x','y'));
		amistad.add(new Amistad('x','z'));

		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		String r1 = "[x, y, z] 1";
		
		Ronda optima = f.solve(exploradoras,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");
		
	}
	

	@Test
	public void testStress(){
		System.out.println("TestStress...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'a','b','c','d','e', 'f', 'g', 'h', 'i', 'j','k'};

		amistad.add(new Amistad('a','f'));
		amistad.add(new Amistad('a','b'));
		amistad.add(new Amistad('b','g'));
		amistad.add(new Amistad('b','c'));		
		amistad.add(new Amistad('d','g'));
		amistad.add(new Amistad('d','c'));
		amistad.add(new Amistad('f','a'));
		amistad.add(new Amistad('f','g'));
		amistad.add(new Amistad('f','h'));
		amistad.add(new Amistad('e','h'));
		amistad.add(new Amistad('e','d'));

		Fogon f = new Fogon();
		
		Ronda optima = f.solve(exploradoras,amistad); 
		
		System.out.println("Ok...");
		
}
	
	@Test
	public void testEscrito() throws IOException //lee del *.in y escribe en el *.out 
	{
		//Los archivos están en /bin/ej3/
		BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.in" ) ) );
	    BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource("").getPath() + "Tp1Ej3.out") );
	    String line;
	    while ( ( line = is.readLine() ) != null ) {
	       Separar sep = new Separar(line);
	       Fogon f = new Fogon();
	       Ronda optima = f.solve(sep.exploradora, sep.amigas);
	       os.append(optima.toString() + " " + optima.distanciaMaxima(sep.amigas));
	       os.append(System.lineSeparator());
	       System.out.println(optima.toString() + " " + optima.distanciaMaxima(sep.amigas));
	    }
	    os.close();
	}
}
