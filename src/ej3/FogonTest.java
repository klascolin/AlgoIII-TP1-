package ej3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

import org.junit.Test;


	  
public class FogonTest extends AbstractBenchmark  {
	 @Rule
	  public TestRule benchmarkRun = new BenchmarkRule();
	//TEST DE CORRECTITUD:
	@Test	
	public void testSolve1(){
		System.out.println("Test1(catedra)...");
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
		
		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		
	
		System.out.println("Ok...");
		
	}
	
	@Test
	public void testSolve2(){
		System.out.println("Test2(catedra)...");
		
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
		Ronda optima = f.solve(exp,amistad); 
		
		assertEquals(s,optima.toString() + " " + optima.distanciaMaxima(amistad));
		
		System.out.println("Okaa...");
		
		
}
	
	@Test
	public void testSolve3(){
		System.out.println("Test3(catedra)...");
		
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
		
		Ronda optima = f.solve(exp,amistad); 
		
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		System.out.println(optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");
		
}
	
	@Test
	public void testSolve4(){
		System.out.println("Test4(catedra)...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'x','y','z'};

		amistad.add(new Amistad('x','y'));
		amistad.add(new Amistad('x','z'));

		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		String r1 = "[x, y, z] 1";
		
		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");
		
	}
	
	@Test
	public void testSolve5(){
		System.out.println("Test5...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'a','c','b','d','e'};

		amistad.add(new Amistad('a','d'));
		amistad.add(new Amistad('a','e'));

		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		String r1 = "[a, d, b, c, e] 1";
		
		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");
		
	}

	@Test
	public void testSolve6(){
		System.out.println("Test6...");
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Character[] exploradoras = {'a','c','b','d','e'};

		amistad.add(new Amistad('c','e'));
		amistad.add(new Amistad('b','d'));

		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		String r1 = "[a, b, d, c, e] 1";
		
		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");
		
	}
	
@Test
	public void testSolveBorder1(){
		//Caso no hay relaciones de amistad
		System.out.println("TestBorder...");
		Character[] exploradoras = {'a','b','c','d'};
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		String  r1 = "[a, b, c, d] 0";
		
		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		System.out.println(optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");
		
		return;
		
	}

	@Test
	
	

	public void testSolveBorder2(){
		//Caso no hay relaciones de amistad, con lista no ordenada
		System.out.println("TestBorder2...");
		Character[] exploradoras = {'d','c','b','a'};
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		String  r1 = "[a, b, c, d] 0";

		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		System.out.println(optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");

		return;

}
	
	public void testWarmUpMejorCaso(int n){
		for(int i = 0;i<20;i++)
			mejorCaso(n);
		
	}

	public void testWarmUPeorCaso(int n){
		for(int i = 0;i<20;i++)
			PeorCaso(n);
		
	}

	public void testWarmUpCasoSinIntencionalidad(int n){
		for(int i = 0;i<20;i++)
			CasoSinIntencionalidad(n);
		
	}

	//Test Performance:
	@Test public void warmup1(){
		this.testWarmUPeorCaso(2);
	}
	@Test
	public void testn2Peor(){
		this.testPromedioPeorCaso(2);
	}
	@Test public void warmup2(){
		this.testWarmUpMejorCaso(2);
	}
	@Test
	public void testn2Mejor(){
		this.testPromedioMejorCaso(2);
	}
	@Test public void warmup3(){
		this.testWarmUpCasoSinIntencionalidad(2);
	}
	@Test
	public void testn2SinI(){
		this.testPromedioSinIntencionalidad(2);
	}
	
	public void testPromedioMejorCaso(int n){
		for(int i = 0;i<500;i++)
			mejorCaso(n);
		
		System.out.println("Ok...");
		
		
}
 		
	public void testPromedioPeorCaso(int n){
		
		//luego tomamos el promedio de ejecucion dividiendo por 500 
		for(int i = 0;i<500;i++)
			PeorCaso(n);
		
		System.out.println("Ok...");
		
}	
	
	public void testPromedioSinIntencionalidad(int n){
		for(int i = 0;i<500;i++)
			this.CasoSinIntencionalidad2(n);
		
		System.out.println("Ok...");
		
}	

	public void mejorCaso(int n){
		
		//n >= 2
		//Considerando la poda, una vez que hayamos encontrado la solucion(que seria en la primer pasada) y estemos
		//analizando la lista [a,c,b], habremos cortado esa rama. Lo mismo pasara con las ramas de [a (d/e) b].
		//Es decir, estaremos podando desde bien arriba.
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		ArrayList<Character> exp = new ArrayList<Character>(n);
		
		for(int i=97;i<97+n;i++)
			exp.add((char)i);
		
		amistad.add(new Amistad('a','b'));
		
		Fogon f = new Fogon();	
		int i ;
		
		System.out.println(f.solve(exp,amistad));
		System.out.println("Ok...");
		
		
		
	}
	
	
	public void mejorCaso2(int n){

		//n>3
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		ArrayList<Character> exp = new ArrayList<Character>(n);
		System.out.println("TestMejorCaso2..");
		for(int i=97;i<97+n;i++)
			exp.add((char)i);
		
	
		amistad.add(new Amistad('a',exp.get(exp.size()-1)));
		
		Fogon f = new Fogon();	
		
		System.out.println(f.solve(exp,amistad)); 
		System.out.println("Ok...");
		
		
		
	}

	public void PeorCaso(int n){
	
		//n>3
		//El peor caso seria cualquiera que obligue a tener que mirar la mayoria de las ramas del arbol
		//Es decir, que las ramas se empiecen a podar deesde bien abajo.
		//En otras palabras, que el orden indicado se encuentre casi al final del backtrack, de manera que 
		//la poda no actue desde el "ppio".
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		ArrayList<Character> exp = new ArrayList<Character>(n);
		System.out.println("TestPeorCaso..");
		for(int i=97;i<97+n;i++)
			exp.add((char)i);

		amistad.add(new Amistad('b',exp.get(exp.size()-1)));
		
		Fogon f = new Fogon();	
		System.out.println( f.solve(exp,amistad).toString()); 
		
		
		
	}

	public void CasoSinIntencionalidad(int n){
		
		//n>3
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		ArrayList<Character> exp = new ArrayList<Character>(n);
		System.out.println("TestSinIntencionalidad..");
		for(int i=97;i<97+n;i++)
			exp.add((char)i);

		amistad.add(new Amistad('c','d'));
		
		Fogon f = new Fogon();	
		System.out.println( f.solve(exp,amistad).toString()); 
		
	
		
	}

	public void CasoSinIntencionalidad2(int n){
		//n>7
		
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		ArrayList<Character> exp = new ArrayList<Character>(n);
		System.out.println("TestSinIntencionalidad2..");
		for(int i=97;i<97+n;i++)
			exp.add((char)i);

		amistad.add(new Amistad('a','g'));
		
		Fogon f = new Fogon();	
		System.out.println( f.solve(exp,amistad).toString()); 
		
		
	}
	
    @Test
    public void testEscrito() throws IOException //lee del *.in y escribe en el *.out
    {
        //Los archivos est�n en /bin/ej3/
        BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.in" ) ) );
        BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource("").getPath() + "Tp1Ej3.out") );
        String line;
        while ( ( line = is.readLine() ) != null ) {
           Separar sep = new Separar(line);
           Fogon f = new Fogon();
           Ronda optima = f.solve(sep.exploradora, sep.amigas);
           os.append(optima.toString() + " " + optima.distanciaMaxima(sep.amigas));
           os.append(System.lineSeparator());
           System.out.println(optima.distanciaMaxima(sep.amigas)+" " + optima.toString());
        }
        os.close();
    }

		
}
