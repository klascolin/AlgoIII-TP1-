package ej2;

public class Test {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	public static void test1(){
		int[] A={2,3,4,1,2};
		Amediana n=new Amediana();
		int[] B= n.formar(A);
		int i=0;
		while(i<B.length){
			System.out.print(B[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println("");
	}
	public static void test2(){
		int[] A={2,7,2,8,4,9,1,6,5};
		Amediana n=new Amediana();
		int[] B= n.formar(A);
		int i=0;
		while(i<B.length){
			System.out.print(B[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println("");
	}
	public static void test3(){
		int[] A={1,87,4};
		Amediana n=new Amediana();
		int[] B= n.formar(A);
		int i=0;
		while(i<B.length){
			System.out.print(B[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println("");
	}
	public static void test4(){
		int[] A={4,0,32,6,8,10};
		Amediana n=new Amediana();
		int[] B= n.formar(A);
		int i=0;
		while(i<B.length){
			System.out.print(B[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println("");
	}
	public static void test5(){
		int[] A={2,50,30,55,70,60,53};
		Amediana n=new Amediana();
		int[] B= n.formar(A);
		int i=0;
		while(i<B.length){
			System.out.print(B[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println("");
	}
	public static void test6(){
		int[] A={50,2,4,2,2,1};
		Amediana n=new Amediana();
		int[] B= n.formar(A);
		int i=0;
		while(i<B.length){
			System.out.print(B[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println("");
	}
}
