package Java10;

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
	public  Point[] getPoints(){
		return new Point[] {getCentre()};
		
	}


	// **************** Interface ******************** //

	@Override
	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	
}
