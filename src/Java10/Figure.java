package Java10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Figure extends Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1702696662531336857L;
	private Couleur couleur;
	public Couleur getCouleur(){
		return couleur;
	}
	
	public Figure(){
		couleur =Couleur.getCouleurDefaut();
	}
	public Figure(Couleur c){
		couleur = c;
	}
	
	
	protected abstract String getType();

	public abstract Point getCentre();
	
	public abstract void affiche();

	public abstract Collection<? extends Point> getPoints();

	public abstract boolean couvre(Point p);
	
	public abstract boolean equals(Object O);
	
	public double distanceOrigine(){
		
 		Point Ori = new Point();
 		double min = Double.POSITIVE_INFINITY;
 		Collection<Point> Cp = new ArrayList<Point>(getPoints());
 		
 		for (Point point : Cp) {
			min = Math.min(Ori.distance(point), min);
		}
		//return min;
		
		
		Point pmin = Collections.min(getPoints(), (p1,p2) -> 
		                         (int) (p1.distanceOrigine() -p2.distanceOrigine()));
		return pmin.distanceOrigine();
	}
	
	
	public int compareTo(Figure f){
		if(this.equals(f)){
			return 0;
		}
		double d1 =this.distanceOrigine();
		double d2 = f.distanceOrigine();
		return (d1 -d2) > 0 ? -1 :1; // souci si la distance son les meme pour 2 figure 
		
	}
}
