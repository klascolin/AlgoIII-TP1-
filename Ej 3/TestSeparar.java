package ej3;

public class TestSeparar {
	public static void main(String[] args) {
		test1();

	}
	public static void test1(){
		String s="a bcde;b acde;c abde;d abc;e abc";
		Separar a=new Separar(s);
		int i=0;
		while(i<a.cantidad){
			System.out.println(a.exploradora[i]+" "+a.amigas[i]);
			i++;
		}
	}
}
