package ej2;
import java.util.PriorityQueue;
import java.util.Collections;
//import java.util.Comparator;

public class Arreglo {
	private PriorityQueue<Integer> menor;
	private int mediana;
	private PriorityQueue<Integer> mayor;
	private int tamaño;
	
	public Arreglo(int n) {
		mediana = 0;
		tamaño = 0;
		menor = new PriorityQueue<Integer>(n/2,Collections.reverseOrder());
		mayor = new PriorityQueue<Integer>(n/2);
	}
	public int mediana(){
//		if((tamaño%2)==1){
			return mediana;
/*		}
		else{
			if(menor.size()>mayor.size()){
				return (mediana+menor.peek())/2;
			}
			else{
				return (mediana+mayor.peek())/2;
			}
		}
*/		
	}
	public void agregar(int n){
		if(tamaño == 0){
			mediana = n;
			tamaño++;
		}
		else if((tamaño % 2) == 1){
			if(n < mediana){
				menor.add(n);
				mayor.add(mediana);
				mediana = (menor.peek() + mayor.peek()) / 2;
//				menor.add(n);
				tamaño++;
			}
			else{
				mayor.add(n);
				menor.add(mediana);
				mediana = (menor.peek() + mayor.peek()) / 2;
//				mayor.add(n);
				tamaño++;
			}
		}
		else{
		/*	if(n==mediana){
				if(menor.size()>mayor.size()){
					mayor.add(n);
					tamaño++;
				}
				else{
					menor.add(n);
					tamaño++;
				}
			}
			else*/ if(n < mediana){
				menor.add(n);
//				mayor.add(mediana);
				int m = menor.poll();
				mediana = m;
				tamaño++;
			}
			else{
				mayor.add(n);
//				menor.add(mediana);
				int m = mayor.poll();
				mediana = m;
				tamaño++;
			}
		}
		System.out.print(menor.size() + "," + mayor.size() + "|");
	}

}




