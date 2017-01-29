package Java10;

import java.util.ArrayList;
import java.util.Collection;
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

		/*
		 * this.basG = new Point(centre.getX()-(L/2),centre.getY()-(H/2));
		 * this.basD = new Point(centre.getX()-(L/2),centre.getY()+(H/2));
		 * this.hautG = new Point(centre.getX()+(L/2),centre.getY()-(H/2));
		 * this.hautD = new Point(centre.getX()+(L/2),centre.getY()+(H/2));
		 */
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
		return "[ " + getType() + getBasG() + ";" + getBasD() + ";" + getHautG() + ";" + getHautD() + "]";
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
		List<Point> lp = new ArrayList<Point>();
				lp.add(getBasD());
				lp.add(getBasG());
				lp.add(getHautD());
				lp.add(getHautG());
				return lp;
		
	}
}
