package uba.algo3.ejemplotp;

import java.util.ArrayList;
import java.util.ListIterator;


public class Ronda {

private ArrayList<exploradora> lista;

private relaciones amistades;


//PRE: Hay al menos 2 exploradoras en la ronda

public int  distanciaMax(){
	
	//Selecciono el candidato a maximaDist
	int maximaDist = distancia(lista.get(0),lista.get(1));
	
	//Creo iterador para mirar la lista:
	ListIterator<exploradora> l1 = lista.listIterator();
	
	while(l.hasNext()){
		//Copio el iterador actual, desde donde esta, para no tener que recorrer desde el ppio.
		ListIterator<exploradora> l2(l1);
		
		//Miro el resto de las exploradores:
		while(l2.hasNext() ){ //O(a)
			//Si son amigas y la distancia es mayor que la que teniamos, es la nueva maximaDist
			if(amistad.sonAmigas(l2.next(),l1.next()) && distancia(l1.nextIndex(),l2.nextIndex()) > maximaDist)
						maximaDist = lista.distancia(l1.nextIndex(),l2.nextIndex());
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
