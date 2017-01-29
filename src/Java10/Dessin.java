package Java10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dessin {

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
