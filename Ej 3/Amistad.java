package uba.algo3.ejemplotp;


public class Amistad {
	private Character x;
	private Character y;
	
	public Amistad(char a,char b){
		x=a;
		y=b;
	}
	
	@Override public String toString(){
	
		String s = "(" + Character.toString(x) + "," + Character.toString(y) + ")";
		return s ;
	}
	
	
	@Override public boolean equals(Object b){
		boolean r=false;
		if(b instanceof Amistad){
			Amistad a=(Amistad) b;
			return ((this.x.equals(a.getX()) && this.y.equals(a.getY())) ||(this.x.equals(a.getY()) && this.y.equals(a.getX())));
		}
		return r;
	}
	public char getX(){
		return x;
	}
	public char getY(){
		return y;
	}
	
	 @Override public int hashCode() {
	        return (41 * (41 + x.charValue() + y.charValue()));
	 }
}
