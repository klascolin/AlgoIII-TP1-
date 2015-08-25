package ej3;

import java.util.HashSet;

public class TestAmistad {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	public static void test1(){
		Amistad a=new Amistad("b".charAt(0),"a".charAt(0));
		Amistad b=new Amistad("b".charAt(0),"a".charAt(0));
		Amistad c=new Amistad("a".charAt(0),"b".charAt(0));
		Amistad d=new Amistad("b".charAt(0),"c".charAt(0));
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.equals(d));
		System.out.println(b.equals(c));
		System.out.println(c.equals(b));
	}
	public static void test2(){
		HashSet<Amistad> A=new HashSet<Amistad>();
		Amistad a=new Amistad("b".charAt(0),"a".charAt(0));
		Amistad b=new Amistad("b".charAt(0),"a".charAt(0));
		//Amistad c=new Amistad("a".charAt(0),"b".charAt(0));
	//	Amistad d=new Amistad("b".charAt(0),"c".charAt(0));
		System.out.println(A.add(a));
		System.out.println(A.size());
		System.out.println(A.contains(b));
		System.out.println(A.add(a));
		System.out.println(A.add(b));
	}
}
