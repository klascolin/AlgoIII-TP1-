package uba.algo3.ejemplotp;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.HashSet;

public class Ronda {

private ArrayList<Character> lista;

public Ronda(){
	
lista = new ArrayList<Character>();

}	



public int  distanciaMax(HashSet<amistad> amistad){
	
	if (lista.size() < 2)
		return 0;
	//Selecciono el candidato a maximaDist
	int maximaDist = distancia(lista.get(0),lista.get(1));
	
	//Creo iterador para mirar la lista:
	ListIterator<Character> l1 = lista.listIterator();
	
	while(l1.hasNext()){
		//Copio el iterador actual, desde donde esta, para no tener que recorrer desde el ppio.
		ListIterator<Character> l2 = new ListIterator<Character>(l1);
		
		//Miro el resto de las exploradores:
		while(l2.hasNext() ){ //O(a)
			amistad r  = new amistad(l2.next(),l1.next());
			//Si son amigas y la distancia es mayor que la que teniamos, es la nueva maximaDist
			if(amistad.contains(r) && distancia(l1.nextIndex(),l2.nextIndex()) > maximaDist)
						maximaDist = distancia(l1.nextIndex(),l2.nextIndex());
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

	
	
	


