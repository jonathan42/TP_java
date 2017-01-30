package Java10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Rectangle extends Figure implements Surfacable {

	private Point basG;
	private Point basD;
	private Point hautG;
	private Point hautD;

	/**
	 * the constructor le rectangle RQ: PB avec des nombres non paire
	 * 
	 * @param centre
	 *            is center of rectangle
	 * @param L
	 *            is Longeur of rectangle
	 * @param H
	 *            is hauteur du rectangle
	 */
	public Rectangle(Point centre, int L, int H) {

		this.basG = new Point(centre.getX(), centre.getY()); // évite la copie
		this.basD = new Point(centre.getX() + L, centre.getY());
		this.hautG = new Point(centre.getX(), centre.getY() + H);
		this.hautD = new Point(centre.getX() + L, centre.getY() + H);

	}
	
	public Rectangle(Couleur c,Point centre, int L, int H) {
		super(c);
		this.basG = new Point(centre.getX(), centre.getY()); // évite la copie
		this.basD = new Point(centre.getX() + L, centre.getY());
		this.hautG = new Point(centre.getX(), centre.getY() + H);
		this.hautD = new Point(centre.getX() + L, centre.getY() + H);

	}

	public Point getBasG() {
		return basG;
	}

	public Point getBasD() {
		return basD;
	}

	public Point getHautG() {
		return hautG;
	}

	public Point getHautD() {
		return hautD;
	}

	@Override
	protected String getType() {
		return "RECT ";
	}

	@Override
	public String toString() {
		return "[ " + getType() + getCouleur()+" :" + getBasG() + ";" + getBasD() + ";" + getHautG() + ";" + getHautD() + "]";
	}

	@Override
	public void affiche() {
		System.out.println(this);
	}

	@Override
	public Point getCentre() {
		int x = (this.getHautD().getX() + this.getBasG().getX()) / 2;
		int y = (this.getBasD().getY() + this.getHautG().getY()) / 2;
		return new Point(x, y);
	}

	@Override
	public double surface() {
		int largeur = this.getHautD().getX() - this.getBasG().getX();
		int hauteur = this.getHautD().getY() - this.getBasG().getY();
		return largeur * hauteur;
	}
	
	@Override
	public  Collection<? extends Point> getPoints(){
		Collection<Point> lp = new HashSet<Point>();
				lp.add(getBasD());
				lp.add(getBasG());
				lp.add(getHautD());
				lp.add(getHautG());
				return lp;
		
	}
	
	
	
	@Override
	public boolean equals(Object o){
		
		if (o instanceof Rectangle){
			
			return ( ((Rectangle) o).getBasD().equals(getBasD())
					&& ((Rectangle) o).getBasG().equals(getBasG())
					&& ((Rectangle) o).getHautD().equals(getHautD())
					&& ((Rectangle) o).getHautG().equals(getHautG())
					);
		}
		return false;
	}
	
	@Override
	 	public boolean couvre(Point p) {
	 		if(p.getX() < getBasG().getX()){
	 			return false;
	 		}
	 		if(p.getX() > getHautD().getX()){
	 			return false;
	 		}
	 		if(p.getY() < getBasG().getY()){
	 			return false;
	 		}
	 		if(p.getY() > getHautD().getY()){
	 			return false;
	 		}
	 		return true;
	 	}
}
