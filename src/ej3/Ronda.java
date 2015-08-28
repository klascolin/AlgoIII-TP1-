package ej3;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.HashSet;

public class Ronda extends ArrayList<Character>{

	//Constructor:

	Ronda(ArrayList<Character> l ){
		super(l);
	}
	Ronda(){
	super();	
	}
	
public int  distanciaMax(HashSet<Amistad> amistad){
	
	if (size() < 2 || amistad.size() == 0)
		return 0;
	//Selecciono el candidato a maximaDist
	int maximaDist = 0;
	
	//Creo iterador para mirar la lista:
	ListIterator<Character> l1 = listIterator();

	while(l1.hasNext()){
		//Tomo valor de iterador y avanzo
		char e1 = l1.next();
		
		//Copio el iterador actual, desde donde esta, para no tener que recorrer desde el ppio.
		ListIterator<Character> l2 = listIterator(l1.nextIndex());
		char e2;
		
		//Verifico que el iterador2 no se pase(esta desfazado uno con respecto a l1)
		
		//Miro el resto de las exploradores:
		while(l2.hasNext() ){ //O(a)
			e2 = l2.next();
			Amistad r  = new Amistad(e2,e1);
			int distancia = distancia(l1.nextIndex(),l2.nextIndex());
			
			//Si son amigas y la distancia es mayor que la que teniamos, es la nueva maximaDist
			if(amistad.contains(r))
				maximaDist = distancia + maximaDist;
			//Avanzo el iterador 2		
		}
	}	
	return maximaDist;		
	}


public int distancia(int a, int b){

	if (b <= a){
		int temp = b;
		b = a;
		a = temp;
	}
	if (b - a > size()/2 )
		return ((size()  - b) + a);
	else
		return (b-a);
	}
	
	

}

	
	
	


