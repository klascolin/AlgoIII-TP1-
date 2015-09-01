package ej2;

public class Amediana {	
	public int[] formar(int[] A){
		int[] B = new int[A.length];
		Arreglo arr = new Arreglo(A.length);
		boolean ordenado = false;
		if (estaOrdenado(A)) //O(n)
			ordenado = true;
		for (int j = 0; j < A.length; j++)
		{
			if (ordenado) //Si está ordenado, recorro secuencialmente el arreglo: O(n)
			{
				if (j == 0)
					B[j] = A[j];
				else if (j % 2 == 1) //tiene cantidad par de números
					B[j] = (A[j / 2] + A[j / 2 + 1]) / 2;
				else
					B[j] = A[j / 2]; //Dado que j vale uno menos que la cantidad de números en el arreglo
			} else //Sino, llamo n veces a un método O(log n) = O (n log n)
			{
			arr.agregar(A[j]);
			B[j] = arr.mediana();
			}
		}
		//System.out.print("/");
		return B;
	}
	
	private boolean estaOrdenado (int[] A)
	{
		for (int i = 0; i < A.length; i++)
		{
			if (i > 0 && A[i] < A[i - 1])
				return false;
		}
		return true;
	}
}
