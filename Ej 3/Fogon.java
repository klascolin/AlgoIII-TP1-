package uba.algo3.ejemplotp;

import java.util.HashSet;

public class Fogon {
	
	//Miembros de la clase:

	private Ronda rondaOptima;
		
	private HashSet<amistad> amigas;

	Fogon(){
	rondaOptima = new Ronda();
	amigas = new HashSet<amistad>();
	
	}

	public solve(Character[]  exploradoras, algo mas para la amistad){
			
	//De alguna manera inicializar el conjunto de amigas
		
	Ronda rondaAux = new Ronda();
	
	sentarExploradoras(exploradoras,rondaAux,0);
	
	return;
	}
	
	//Metodos:
	
	//PRE: exploradoras debe estar ordenado alfabeticamente
	
	public void sentarExploradoras(Character[] exploradoras, Ronda rondaAux, int k){
		
		//Se pueden agregar "podas"? Si la vamos armando y ya vemos que una distancia es mayor que la optima actual...
		
		//Veo si es una ronda completa:
		
			if(rondaAux.size() == exploradoras.length){  //O(1)
				
				//Si la solucion es mejor que la optima actual, pasa a ser la nueva optima:
				if(rondaAux.distanciaMax() < rondaOptima.distanciaMax() || rondaOptima.esVacia() ) // DistanciaMax debe ser O((e^2)*a)
					rondaOptima = rondaAux;
		
				//Descartamos la ultima eleccion y retornamos
					rondaAux.SacarUltimo();
					return;
			}	
		
		//Si no esta completa, exploramos las proximas elecciones:
		for(i=k,i<exploradoras.length,i++){
			
			//Probamos con una nueva exploradora:
			rondaAux.agregar(exploradoras[i]));			
			//Mandamos el Backtrack:
			sentarExploradoras(exploradoras, rondaAux,k++);
			//Descartamos la ultima eleccion y ciclamos para probar con la proxima
			rondaAux.SacarUltimo();
		}
		
		return;

	}
	
	
}
ss
