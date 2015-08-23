package uba.algo3.ejemplotp;

import java.util.ArrayList;
import java.util.ListIterator;


public class Ronda {

private ArrayList<exploradora> lista;

private relaciones amistades;


//PRE: Hay al menos 2 exploradoras en la ronda

public int  distanciaMax(){
	
	int maximaDist = distancia(lista.get(0),lista.get(1));
	
	ListIterator<exploradora> l1 = lista.listIterator();
	while(l.hasNext()){
		ListIterator<exploradora> l2(l1); //Copio el iterador actual, desde donde esta, para no tener que recorrer desde el ppio.
		while(l2.hasNext() && amistad.sonAmigas(l2.next(),l1.next()) ){ //O(a)
				if(distancia(l1.nextIndex(),l2.nextIndex()) > maximaDist)
						maximaDist = lista.distancia(l1.nextIndex(),l2.nextIndex())
		}
	}
	
	return maximaDist;		
			
			
	}

//PRE : b > a
public int distancia(int a, int b){
	
	if (b-a > lista.size()/2 )
		return ((lista.size()  - (b+1)) + a) ;
	else
		return (b-a);

	
	
}

	
	
		
		
	
}


}
