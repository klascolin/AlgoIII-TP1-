package ej3;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Separar {
	public Character[] exploradora;
	public HashSet<Amistad> amigas;
	public int cantidad;
	
	public Separar(String s){
		StringTokenizer st=new StringTokenizer(s,";");
		amigas=new HashSet<Amistad>();
		cantidad=st.countTokens();
		StringTokenizer nt;
		HashSet<Character> e=new HashSet<Character>();
		while(st.hasMoreTokens()){
			nt=new StringTokenizer(st.nextToken());
			String g= nt.nextToken();
			String m=nt.nextToken();
			int n=0;
			while(n<m.length()){
				e.add(m.charAt(n));
				Amistad r = new Amistad(g.charAt(0),m.charAt(n));
				boolean b=amigas.add(r);
				if(b){
					System.out.println(g.charAt(0)+" "+m.charAt(n));
				}
				n++;
			}
		}
		exploradora=(Character[]) e.toArray(new Character[0]);
	}

}
