package ej3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

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
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima);
		
	
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
		
		assertEquals(s,optima.toString() + " " + optima.distanciaMaxima);
		
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
		
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima);
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		System.out.println(optima.toString() + " " + optima.distanciaMaxima);
		//System.out.println("Ok...");
		
}
	

/*
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
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima);
		System.out.println("Ok...");
		
}
*/
	
	@Test
	public void testArchivo() //lee del *.in y lo compara con el *.out
	{
		BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.in" ) ) );
		BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.out" ) ) );

	    String line;
	    String out;
	    Fogon f = new Fogon();
	    try
	    {
	    while ( ( line = source.readLine() ) != null ) { //Por cada linea en el archivo
	    	Separar sep = new Separar(line);
	        //System.out.println(sep.amigas.toString());
	        //System.out.println(sep.exploradora.toString());
	    	//System.out.println(sep.amigas.toString());
	    	ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(sep.exploradora));
	        Ronda optima = f.solve(sep.exploradora, sep.amigas);
//	        out = control.readLine();
//	        System.out.println(exp.toString());
//	        System.out.println(sep.amigas.toString());
//	        System.out.println(optima.toString() + " " + optima.distanciaMaxima);
	        System.out.println(line);
	        //System.out.println(out);
	        assertEquals(control.readLine(), optima.toString() + " " + optima.distanciaMaxima); //Formato: "[a, b, ..., z] distMax" 
	    }
	    }
    catch(Exception e){
	    }
	}
}
