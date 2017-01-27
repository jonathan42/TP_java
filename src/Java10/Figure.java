package Java10;

public abstract class Figure extends Object {

	protected abstract String getType();

	public abstract Point getCentre();
	
	public abstract void affiche();

	public abstract Point[] getPoints();

	
}
