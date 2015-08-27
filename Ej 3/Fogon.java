package uba.algo3.ejemplotp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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

	sentarExploradoras(exp,rondaAux);
	

	return rondaOptima;
	}
	
	//Metodos:
	
	//PRE: exploradoras debe estar ordenado alfabeticamente
	
	public void sentarExploradoras(ArrayList<Character> exploradoras, Ronda rondaAux){
		
		//Se pueden agregar "podas"? Si la vamos armando y ya vemos que una distancia es mayor que la optima actual...
		
		//Veo si es una ronda completa:
 			if(rondaAux.size() == exploradoras.size()){  //O(1)
				
				//Si la solucion es mejor que la optima actual, pasa a ser la nueva optima:
				if((rondaAux.distanciaMax(amigas) < rondaOptima.distanciaMax(amigas)) || (rondaOptima.size() == 0) ) // DistanciaMax debe ser O((e^2)*a)
					rondaOptima = new Ronda(rondaAux);
		
				//Descartamos la ultima eleccion y retornamos
				//rondaAux.remove(rondaAux.size() - 1);
				return;
			}	
		
		//Si no esta completa, exploramos las proximas elecciones:
		for(int i = 0; i < exploradoras.size(); i++){
			
			if (!rondaAux.contains(exploradoras.get(i))){
			 
				rondaAux.add(exploradoras.get(i));
					
				sentarExploradoras(exploradoras, rondaAux);
				
			//	if(i == exploradoras.size() -1 || (rondaAux.size() <= exploradoras.size() -2))
					rondaAux.remove(rondaAux.size()-1);	
				
				}	
			
		}
		
		return;
	}
}