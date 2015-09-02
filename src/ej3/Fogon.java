package ej3;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

	public class Fogon {
	
	//Miembros de la clase:

	private Ronda rondaOptima;

	
	private HashSet<Amistad> amigas;


	Fogon(){
		
	rondaOptima = new Ronda();
	amigas = new HashSet<Amistad>();
	
	}

	public Ronda solve(ArrayList<Character>  exploradoras, HashSet<Amistad> amistades){
			
	//De alguna manera inicializar el conjunto de amigas

	amigas = amistades;	
		
	Ronda rondaAux = new Ronda();

	Collections.sort(exploradoras);
		
	//Si no hay amistades, simplemente devolvemos la ronda igual a la lista(ordenada)
	if(amistades.isEmpty())
		rondaOptima = new Ronda(exploradoras);
	else{
		//Todas las rondas que son solucion comienzan con la primer letra. 
		//La sacamos para evitar mirar soluciones de mas
		if(!exploradoras.isEmpty()){	
			rondaAux.add(exploradoras.get(0));
			exploradoras.remove(0);
		}
		//Llamamos a la funcion que hace backtracking para que arme la rondaOptima.
		sentarExploradoras(exploradoras,rondaAux,exploradoras.size());
	}
	return rondaOptima;
	}
	
	//Metodos:
	
	//PRE: exploradoras debe estar ordenado alfabeticamente
	 
	public void sentarExploradoras(ArrayList<Character> exploradoras, Ronda rondaAux, int tam){
		
		
		
		//Veo si es una ronda completa:
 			if(rondaAux.size() == tam + 1 ){  //O(1)			
				//Si la solucion es mejor que la optima actual, pasa a ser la nueva optima:
 				if((rondaAux.sumaDistancias(amigas) < rondaOptima.sumaDistancias(amigas)) || (rondaOptima.isEmpty()))
 					rondaOptima = new Ronda(rondaAux);
 					return;
			}	
		
		//Si no esta completa, exploramos las proximas elecciones:
		for(int i = 0; i < exploradoras.size(); i++){
				//Elegimos el primero de la lista
				
				char e = exploradoras.get(i);
				rondaAux.add(e);
				
				//PODA1:Recortamos la rama que mira la ronda "al reves"
				if(rondaAux.size() == 2 && i == exploradoras.size()-1 ){
					System.out.println("PODAA");
					break;
					
				}
				
				//PODA2: Si la distancia de la ronda actual ya es peor que la optima, 
				if((rondaAux.sumaDistancias(amigas) >= rondaOptima.sumaDistancias(amigas)) && (rondaOptima.size() != 0 )){ 
					rondaAux.remove(rondaAux.size() - 1);
				}
				
				else{
			
				//Lo sacamos, para que en el proximo nivel de recursion, no este disponible.
				//Esto garantiza que no se pueda volver a agarrar
				exploradoras.remove(i);
				
				//Hacemos Backtrack
				sentarExploradoras(exploradoras, rondaAux,tam);
						
				//Sacamos de la ronda la ultima eleccion y la recordamo
				
				char ult = rondaAux.remove(rondaAux.size() - 1);
				assertEquals(ult,e);
				//La volvemos a agregar adelante de la lista
				//Esto permite mantener invariable la lista a los ojos del nivel de arriba del backtrack
				exploradoras.add(i,e);
			 }
		}	
		return;
	}
}
