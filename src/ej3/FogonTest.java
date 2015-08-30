package ej3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.junit.Test;
import org.junit.Test;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;


public class FogonTest {
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
		
		System.out.println("Ok...");
		
		
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
	
	@Test
	public void testSolveBorder3(){
		//Caso vacio
		System.out.println("TestBorder3...");
		Character[] exploradoras = {};
		HashSet<Amistad> amistad = new HashSet<Amistad>();
		Fogon f = new Fogon();
		ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
		String  r1 = "[] 0";

		Ronda optima = f.solve(exp,amistad); 
		assertEquals(r1,optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println(exp.toString());
		System.out.println(amistad.toString());
		System.out.println(optima.toString() + " " + optima.distanciaMaxima(amistad));
		System.out.println("Ok...");

		return;

}

	//TEST DE PERFORMANCE:
	
		@RunWith(Theories.class)
		public class PerformanceTest {

		PerformanceTest(){
			
		}
		
		@Theory

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
			System.out.println(f.prueba);
			
			
		}


	    public  @DataPoint int[] candidates = {4, 5, 6};
	}

	public void testWarmUpMejorCaso(int n){
		for(int i = 0;i<100;i++)
			mejorCaso(n);
		
	}

	public void testWarmUPeorCaso(int n){
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		
	}

	public void testWarmUpCasoSinIntencionalidad(int n){
		for(int i = 0;i<100;i++)
			CasoSinIntencionalidad(n);
		
	}

	public void testPromedioMejorCaso(int n){
		for(int i = 0;i<100;i++)
			mejorCaso(n);
		for(int i = 0;i<100;i++)
			mejorCaso(n);
		for(int i = 0;i<100;i++)
			mejorCaso(n);
		for(int i = 0;i<100;i++)
			mejorCaso(n);
		for(int i = 0;i<100;i++)
			mejorCaso(n);
		//Tomar el promedio, omitiendo la primer corrida
		System.out.println("Ok...");
		
		
		
		//Tomar el promedio, omitiendo la primer corrida
		System.out.println("Ok...");
		
}
 		
	public void testPromedioPeorCaso(int n){
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		//Tomar el promedio, omitiendo la primer corrida
		System.out.println("Ok...");
		
}	
	
	public void testPromedioSinIntencionalidad(int n){
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		for(int i = 0;i<100;i++)
			PeorCaso(n);
		//Tomar el promedio, omitiendo la primer corrida
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
		System.out.println(f.prueba);
		
		
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
		System.out.println(f.prueba);
		
		
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
		System.out.println(f.prueba);
		
		
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
		System.out.println(f.prueba);
	
		
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
		System.out.println(f.prueba);	
		
	}

	
	
	
//Sigue tirando el error de la excepcion:S
	
	public void testArchivo() //lee del *.in y lo compara con el *.out
	{
		BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.in" ) ) );
		BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.out" ) ) );
		
		HashSet<Amistad> amistades = new HashSet<Amistad>();
		Character[] exploradoras = new Character[27];
	    String line;
	    String amistad;
	    int indice = 0;
	    char c = '\0'; //Me guardo la primera, este es el valor nulo para inicializar la variable
	    while ( ( line = source.readLine() ) != null ) { //Por cada l�nea en el archivo
	        StringTokenizer st = new StringTokenizer(line, ";"); //La separo entre amistades
	        while ( st.hasMoreTokens() ) { //Por cada amistad
	        	amistad = st.nextToken();
	        	exploradoras[indice] = amistad.charAt(0); //Agrego el caracter/exploradora
	        	indice++;
	        	for (int i = 0; i < amistad.length(); i++) //Recorro la amistad
	        	{
	        		if (i == 0)
	        			c = amistad.charAt(i);
	        		else if (i > 2) //salteo el espacio en blanco
	        			amistades.add(new Amistad(c, amistad.charAt(i))); //Agrego amistad al primer caracter/exploradora
	        	}
	        }
	     //solve.toString() = Aca llamo al solve con las exploradoras y amistades ya armadas
	     //assertEquals( control.readLine(), solve ) //comparo el resultado con el output esperado
	    }
	}
		
}
