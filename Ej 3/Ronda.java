package uba.algo3.ejemplotp;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.HashSet;

public class Ronda extends ArrayList<Character>{

	//Constructor:

	Ronda(ArrayList<Character> l ){
		super(l);
		
		
	}
	//Comparable:
	
	/*public boolean equals( Ronda other ) {
	    
		//Esto podria ser util definirlo para usarlo como poda, asi (si son rondas iguales) no calculamos las distancias con amistad.
		//Sin embargo, no se me ocurre como hacer esto "eficientemente"
		
	}*/


public int  distanciaMax(HashSet<Amistad> amistad){
	
	if (size() < 2 || amistad.size() == 0)
		return 0;
	//Selecciono el candidato a maximaDist
	int maximaDist = 1;
	
	//Creo iterador para mirar la lista:
	ListIterator<Character> l1 = listIterator();
	
	while(l1.hasNext()){
		//Copio el iterador actual, desde donde esta, para no tener que recorrer desde el ppio.
		ListIterator<Character> l2 = listIterator(l1.nextIndex());
		
		//Miro el resto de las exploradores:
		while(l2.hasNext() ){ //O(a)
			Amistad r  = new Amistad(l2.next(),l1.next());
			//Si son amigas y la distancia es mayor que la que teniamos, es la nueva maximaDist
			if(amistad.contains(r) && distancia(l1.nextIndex(),l2.nextIndex()) > maximaDist)
						maximaDist = distancia(l1.nextIndex(),l2.nextIndex());
		}
	}
	
	return maximaDist;		
			
			
	}

//PRE : b > a
public int distancia(int a, int b){
	if (b-a > size()/2 )
		return ((size()  - (b+1)) + a) ;
	else
		return (b-a);
	
	}

}

	
	
	


