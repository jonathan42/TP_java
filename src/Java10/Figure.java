package Java10;

import java.util.Collection;

public abstract class Figure extends Object {

	protected abstract String getType();

	public abstract Point getCentre();
	
	public abstract void affiche();

	public abstract Collection<? extends Point> getPoints();

	public abstract boolean couvre(Point p);
	
	public abstract boolean equals(Object O);
	
}
