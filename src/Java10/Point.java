package Java10;

public class Point extends Object{

	public static final int INIT_X =25;
	public static final int INIT_Y =25;
	
	private int x;
	private int y;
	
	private static final Point ORIGINE = new Point();
	
	public Point() {
		this(INIT_X, INIT_Y);
	}
	
	public Point(int abscisse, int ordonnee) {
		this.x = abscisse;
		this.y = ordonnee;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public String toString(){
		
		return "["+getX() +";"+ getY()+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // true si c'est un object
			return true;
		if (obj == null) // false si l'object est null
			return false;
		if (! (obj instanceof Point)) // false si les intances sont diff (pour validé les classe enfant
			return false; 
		Point other = (Point) obj; // on cast l'object
		if (getX() != other.getX())  //false si diff des X
			return false;
		if (getY() != other.getY()) // false si diff des Y
			return false;
		return true; // true sinon
	}
	
	public double distance(Point p){
		
		return Math.sqrt( Math.exp(this.getX()-p.getX()) + Math.exp(this.getY()-p.getY()) ); 
	}
	
	public double distanceOrigine(){
		return distance(ORIGINE);
	}
	
	
	
	
	
	
}
