package Java10;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;


public class Rond extends Figure implements Surfacable,  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2253226645114023647L;
	private Point centre;
	private int rayon;

	public Rond(Point centre, int rayon) {
		this.centre = centre;
		this.rayon = rayon;
	}

	public Rond(Couleur couleur,Point centre, int rayon) {
		super(couleur);
		this.centre = centre;
		this.rayon = rayon;
	}

	
	public int getRayon() {
		return rayon;
	}


	// ************** Heritage Abstract ******************* //

	@Override
	public String toString() {
		return "["+getType() + getCouleur() + " : "+ getCentre() + ";" + getRayon() + "]";
	}

	@Override
	public void affiche(){
		System.out.println(this);
	}

	
	@Override
	protected String getType() {
		return " ROND ";
	}

	@Override
	public Point getCentre() {
		return this.centre;
	}
	@Override
	public  Collection<? extends Point> getPoints(){
		 Collection<Point> lp =new HashSet<Point>();
		 lp.add(getCentre());
		 return lp;
		
	}
	@Override
	 	public boolean couvre(Point p) {
	 		int x2 = (p.getX() - centre.getX()) * (p.getX() - centre.getX());
	 		int y2 = (p.getY() - centre.getY()) * (p.getY() - centre.getY());
	 		int d = (int) Math.round(Math.sqrt( x2 + y2 ));
	 		return d <= rayon;
	 	}

	
	@Override
	public boolean equals(Object o){
		
		if (o instanceof Rond){
			return ((Rond) o).getCentre().equals(this.getCentre()) && ((Rond) o).getRayon() ==this.getRayon();
		}
		return false;
		
	}
	// **************** Interface ******************** //

	@Override
	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	
}
