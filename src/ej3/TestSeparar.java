package ej3;

import java.util.Iterator;

public class TestSeparar {
	public static void main(String[] args) {
		test1();
	}
	public static void test1(){
		String s = "a bcde;b acde;c abde;d abc;e abc";
		Separar a = new Separar(s);
		int i = 0;
		Iterator<Amistad> it = a.amigas.iterator();
		while(i < a.cantidad && it.hasNext()){
			System.out.println(a.exploradora[i] + " " + it.next().toString());
			i++;
		}
	}
}
