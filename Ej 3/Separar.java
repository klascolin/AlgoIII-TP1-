package uba.algo3.ejemplotp;

import java.util.StringTokenizer;

public class Separar {
	public Character[] exploradora;
	public String[] amigas;
	public int cantidad;
	
	public Separar(String s){
		StringTokenizer st=new StringTokenizer(s,";");
		exploradora=new Character[st.countTokens()];
		amigas=new String[st.countTokens()];
		cantidad=st.countTokens();
		int i=0;
		StringTokenizer nt;
		while(st.hasMoreTokens()){
			nt=new StringTokenizer(st.nextToken());
			exploradora[i]=nt.nextToken().charAt(0);
			amigas[i]=nt.nextToken();
			i++;
		}
		
	}
}
