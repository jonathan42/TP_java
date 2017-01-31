package Java10;

import java.io.Serializable;

public class Carre extends Rectangle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8893151555203252511L;

	public Carre(Point centre, int cote){
		super(centre,cote,cote);		
	}
	
	public Carre(Couleur couleur, Point centre, int cote){
		super(couleur,centre,cote,cote);		
	}
	
	@Override
	protected String getType(){
		return "CARRE ";
	}
	
	
}
