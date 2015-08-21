package ej2;



public class Amediana {
	
	
	public int[] formar(int[] A){
		int[] B= new int[A.length];
		int n=A.length;
		int i=0;
		Arreglo arr= new Arreglo(n);
		while(i<n){
			arr.agregar(A[i]);
			B[i]=arr.mediana();
			i++;
		}
		System.out.print("/");
		return B;
	}
}
