package Java10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Segment extends Figure {

	private Point debut;
	private Point fin;
	
	public Segment(Point debut, int longueur, boolean horizontal) {
		this.debut = debut;
		if (!horizontal) {
			this.fin = new Point(debut.getX(), debut.getY() + longueur);
		} else {
			this.fin = new Point(debut.getX() + longueur, debut.getY());
		}
	}

	
	
	protected Point getDebut() {
		return debut;
	}

	protected Point getFin() {
		return fin;
	}




	@Override
	protected String getType() {
		return " SEG ";
	}

	@Override
	public Point getCentre() {
		if (debut.getX() == fin.getX()) {
			return new Point(debut.getX(), debut.getY()-fin.getY());
		} else {
			return new Point(debut.getX()-fin.getX(), debut.getY());

		}
	}
	
	
	@Override
	public  Collection<? extends Point> getPoints(){
		Collection<Point> lp =new HashSet<Point>();
		 lp.add(getDebut());
		 lp.add(getFin());
		return lp;
		
	}

	@Override
	public boolean equals(Object o){
		
		if (o instanceof Segment){
			return ((Segment) o).getDebut().equals(getDebut()) && ((Segment) o).getFin().equals(getFin());
		}
		return false;
	}
	
	@Override
	 	public boolean couvre(Point p) {
	 		if(p.getX() < getDebut().getX()){
	 			return false;
	 		}
	 		if(p.getX() > getFin().getX()){
	 			return false;
	 		}
	 		if(p.getY() < getDebut().getY()){
	 			return false;
	 		}
	 		if(p.getY() > getFin().getY()){
	 			return false;
	 		}
	 		return true;
	 	}

	@Override
	public  String toString(){
		return "[ "+ getType() + getDebut() + " à " + getFin() + "]";
	}
	@Override
	public void affiche() {
		System.out.println(this);

	}

}
