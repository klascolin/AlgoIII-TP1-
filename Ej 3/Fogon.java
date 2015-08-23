package uba.algo3.ejemplotp;

public class Fogon {
	
	//Miembros de la clase:

	private ronda rondaOptima;
	
	private ronda rondaAux;
	
	private amistad amigas;
	
	//Metodos:
	
	public void sentarExploradoras(lista exploradoras, int k){
		
		//Se pueden agregar "podas"? Si la vamos armando y ya vemos que una distancia es mayor que la optima actual...
		
		//Veo si es una ronda completa:
		
			if(rondaAux.size() == exploradoras.size()){  //O(1)
				
				//Si la solucion es mejor que la optima actual, pasa a ser la nueva optima:
				if(rondaAux.distanciaMax() > rondaOptima.distanciaMax()) // DistanciaMax debe ser O((e^2)*a)
					rondaOptima = rondaAux;
		
				//Descartamos la ultima eleccion y retornamos
					rondaAux.SacarUltimo();
					return;
			}	
		
		//Si no esta completa, exploramos las proximas elecciones:
		for(i=k,i<exploradoras.size(),i++){
			
			//Probamos con una nueva exploradora:
			rondaAux.agregar(get(exploradoras,i));			
			//Mandamos el Backtrack:
			sentarExploradoras(exploradoras,k++);
			//Descartamos la ultima eleccion y ciclamos para probar con la proxima
			rondaAux.SacarUltimo();
		}
		
		return;

	}
	
	
}
