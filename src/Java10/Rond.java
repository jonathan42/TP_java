package Java10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Java10.Point;

public class Rond extends Figure implements Surfacable{

	private Point centre;
	private int rayon;

	public Rond(Point centre, int rayon) {
		this.centre = centre;
		this.rayon = rayon;
	}

	
	public int getRayon() {
		return rayon;
	}


	// ************** Heritage Abstract ******************* //

	@Override
	public String toString() {
		return "["+getType() + getCentre() + ";" + getRayon() + "]";
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
		 List<Point> lp =new ArrayList<Point>();
		 lp.add(getCentre());
		 return lp;
		
	}


	// **************** Interface ******************** //

	@Override
	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	
}
