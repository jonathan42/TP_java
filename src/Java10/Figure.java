package Java10;

import java.util.Collection;

public abstract class Figure extends Object {

	protected abstract String getType();

	public abstract Point getCentre();
	
	public abstract void affiche();

	public abstract Collection<? extends Point> getPoints();

	
}
