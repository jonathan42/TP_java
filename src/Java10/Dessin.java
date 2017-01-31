package Java10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dessin implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9098123905049734523L;
	
	private List<Figure> dessin= new ArrayList<Figure>();
	
	public Dessin(){	
	}
	
	public boolean add(Figure figure){
		return dessin.add(figure);	
	}
	
	public Collection<Figure> getFigures(){
		return this.dessin;
	}
}
