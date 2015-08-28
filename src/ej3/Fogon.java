package ej3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

	public class Fogon {
	
	//Miembros de la clase:

	private Ronda rondaOptima;
		
	private HashSet<Amistad> amigas;
	private int pep;

	Fogon(){
		
	rondaOptima = new Ronda();
	amigas = new HashSet<Amistad>();
	
	}

	public Ronda solve(Character[]  exploradoras, HashSet<Amistad> amistades){
			
	//De alguna manera inicializar el conjunto de amigas

	amigas = amistades;
		
	Ronda rondaAux = new Ronda();
	
	ArrayList<Character> exp = new ArrayList<Character>(Arrays.asList(exploradoras));
	
	rondaAux.add('a');
	exp.remove('a');
	
	sentarExploradoras(exp,rondaAux,exp.size());
	
	

	return rondaOptima;
	}
	
	//Metodos:
	
	//PRE: exploradoras debe estar ordenado alfabeticamente
	
	public void sentarExploradoras(ArrayList<Character> exploradoras, Ronda rondaAux, int tam){
		
		//Se pueden agregar "podas"? Si la vamos armando y ya vemos que una distancia es mayor que la optima actual...
		
		//Veo si es una ronda completa:
 			if(rondaAux.size() == tam){  //O(1)			
				//Si la solucion es mejor que la optima actual, pasa a ser la nueva optima:
				if((rondaAux.distanciaMax(amigas) < rondaOptima.distanciaMax(amigas)) || (rondaOptima.size() == 0) ) // DistanciaMax debe ser O((e^2)*a)
					rondaOptima = new Ronda(rondaAux);		
				return;
			}	
		
		//Si no esta completa, exploramos las proximas elecciones:
 		//Notar que la lista de exploradoras, en cada nivel de la recursion, se qued
		for(int i = 0; i < exploradoras.size(); i++){
				//Elegimos el primero de la lista
				rondaAux.add(exploradoras.get(i));
				
				//Lo sacamos, para que en el proximo nivel de recursion, no este disponible.
				//Esto garantiza que no se pueda volver a agarrar
				exploradoras.remove(i);
				
				//Hacemos Backtrack
				sentarExploradoras(exploradoras, rondaAux,tam);
				
				//Sacamos de la ronda la ultima eleccion y la recordamos
				char ultima = rondaAux.remove(rondaAux.size() - 1);
				
				//La volvemos a agregar adelante de la lista
				//Esto permite mantener invariable la lista a los ojos del nivel de arriba del backtrack
				exploradoras.add(i, ultima);
				}	
		return;
	}
}
