package uba.algo3.ejemplotp;

import java.util.HashSet;

public class Fogon {
	
	//Miembros de la clase:

	private Ronda rondaOptima;
		
	private HashSet<Amistad> amigas;

	Fogon(){
	rondaOptima = new Ronda();
	amigas = new HashSet<Amistad>();
	
	}

	public Ronda solve(Character[]  exploradoras, HashSet<Amistad> amistades){
			
	//De alguna manera inicializar el conjunto de amigas
	amigas = amistades;
		
	Ronda rondaAux = new Ronda();
	
	sentarExploradoras(exploradoras,rondaAux,0);
	
	return rondaOptima;
	}
	
	//Metodos:
	
	//PRE: exploradoras debe estar ordenado alfabeticamente
	
	public void sentarExploradoras(Character[] exploradoras, Ronda rondaAux){
		
		//Se pueden agregar "podas"? Si la vamos armando y ya vemos que una distancia es mayor que la optima actual...
		
		//Veo si es una ronda completa:
		
			if(rondaAux.size() == exploradoras.length){  //O(1)
				
				//Si la solucion es mejor que la optima actual, pasa a ser la nueva optima:
				if(rondaAux.distanciaMax(amigas) < rondaOptima.distanciaMax(amigas) || (rondaOptima.size() == 0) ) // DistanciaMax debe ser O((e^2)*a)
					rondaOptima = rondaAux;
		
				//Descartamos la ultima eleccion y retornamos
				rondaAux.remove(rondaAux.size() - 1);
				return;
			}	
		
		//Si no esta completa, exploramos las proximas elecciones:
		for(int i = 0; i < exploradoras.length; i++){
			//Probamos con una nueva exploradora:
			for (int j  = i; j < exploradoras.length; j++){ //O(e)
				if (!rondaAux.contains(exploradoras[j])
					rondaAux.add(exploradoras[j]);
			}
			//Mandamos el Backtrack:
			sentarExploradoras(exploradoras, rondaAux);
			//Descartamos la ultima eleccion y ciclamos para probar con la proxima
			rondaAux.remove(rondaAux.size() - 1);
		}
		
		return;

	}
	
	
}
