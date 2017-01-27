package Java10;


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
	public  Point[] getPoints(){
		return new Point[] {getDebut(),getFin()};
		
	}


	@Override
	public  String toString(){
		return "[ "+ getType() + getDebut() + " � " + getFin() + "]";
	}
	@Override
	public void affiche() {
		System.out.println(this);

	}

}
