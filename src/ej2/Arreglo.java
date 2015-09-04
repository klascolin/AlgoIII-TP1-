package ej2;

import java.util.PriorityQueue;
import java.util.Collections;

public class Arreglo {
	private PriorityQueue<Integer> menor;
	private int mediana;
	private PriorityQueue<Integer> mayor;
	private int tama�o;
	
	public Arreglo(int n) {
		mediana = 0;
		tama�o = 0;
		//El tama�o del heap es n / 2 + 1 si n es impar
		menor = new PriorityQueue<Integer>(((n % 2 == 0) ? n / 2 : (n / 2 + 1)), Collections.reverseOrder());
		mayor = new PriorityQueue<Integer>(((n % 2 == 0) ? n / 2 : (n / 2 + 1)));
	}
	
	public int mediana(){ //O(1)
		return mediana;
	}
	
	public void agregar(int n){
		if(tama�o == 0) //O(1)
			mediana = n;
		else if((tama�o % 2) == 1){ //Todas las condiciones tienen la misma complejidad O(log (n / 2))
			//Tama�o siempre tiene uno menos que la cantidad de elementos real (ya que se suma al final)
			//Ac� el arreglo tiene tama�o par
			if (n < mediana){ 
				menor.add(n); //O(log (n/2))
				mayor.add(mediana); //O(log (n/2))
				mediana = (menor.peek() + mayor.peek()) / 2; //O(1)
			}
			else{
				mayor.add(n);
				menor.add(mediana);
				mediana = (menor.peek() + mayor.peek()) / 2;
			}
		}
		else{
			if (n < mediana){
				menor.add(n);
				mediana = menor.poll();
			}
			else{
				mayor.add(n);
				mediana = mayor.poll();
			}
		}
		tama�o++;
	}

}




