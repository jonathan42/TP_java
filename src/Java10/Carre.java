package Java10;

public class Carre extends Rectangle{
	
	public Carre(Point centre, int cote){
		super(centre,cote,cote);		
	}
	
	@Override
	protected String getType(){
		return "CARRE ";
	}
	
	
}
