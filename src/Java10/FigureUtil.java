package Java10;

public class FigureUtil {

	private static final int x_max = 50;
	private static final int x_min = 0;

	private static final int y_max = 50;
	private static final int y_min = 0;

	private static final int size_max = 20;
	private static final int size_min = 2;

	// Création d'un constructeur private afin d'interdire l'instanciation de
	// cette classe.
	private FigureUtil() {
	}

	private static int getRandomInteger(int min, int max) {

		return (int) Math.round(Math.random() * (max - min)) + min;
	}

	private static Point getRandomPoint(int x_min, int x_max, int y_min, int y_max) {

		int x = getRandomInteger(x_min, x_max);
		int y = getRandomInteger(y_min, y_max);
		return new Point(x, y);
	}

	public static Rond getRandomRond() {

		int rayon = getRandomInteger(size_min / 2, size_max / 2);
		Point p = getRandomPoint(x_min, x_max, y_min, y_max);
		return new Rond(p, rayon);

	}

	public static Rectangle getRandomRectangle() {

		int L = getRandomInteger(size_min, size_max);
		int H = getRandomInteger(size_min, size_max);
		Point p = getRandomPoint(x_min, x_max, y_min, y_max);
		return new Rectangle(p, L, H);

	}

	public static Carre getRandomCarre() {
		int cote = getRandomInteger(size_min, size_max);
		Point basGauche = getRandomPoint(x_min, x_max, y_min, y_max);
		// Couleur couleur = getRandomCouleur();
		Carre carre = new Carre(basGauche, cote);
		// ids.put(carre.getId(), carre);
		return carre;
	}
	
	public static Segment getRandomSegment(){
		Point debut = getRandomPoint(x_min, x_max, y_min, y_max);
		int longueur = getRandomInteger(size_min, size_max);
		boolean horizontal = getRandomInteger(0, 1) > 0.5; //pour le test
		
		Segment seg = new Segment(debut, longueur, horizontal);
		return seg;
	}

	
	public static Figure getRandomFigure() {
		int choix = getRandomInteger(0, 3);
		switch (choix) {
		case 0:
			return getRandomRond();
		case 1:
			return getRandomCarre();
		case 2:
			return getRandomSegment();
		default:
			return getRandomRectangle();
		}

	}
	
	
	// fonction avec entre variable
	public static int somme (int... valeurs){ //c'est une ellipse
		int s=0;
		for(int v:valeurs){
			s+=v;
		}
		return s;
	}
	
	
	public static Point[] getPoints(Figure... figures){
		// Il peut y avoir des doublons
		int nbPoint =0; 
		for(Figure f : figures){
			nbPoint+=  f.getPoints().length;
		}
		
		Point points[] = new Point[nbPoint];
		int i =0;
		
		
		if (i !=0){
		for(Figure f : figures){
			for (Point p :f.getPoints()){
				points[i] =  p;
				i++;
			}		
		}
		
		}
		return points;
}
	
	
	public static Surfacable getRandomSurfacable(){
		int choix = getRandomInteger(0, 2);
		switch(choix){
		case 0 : 
			return getRandomRond();
		case 1 : 
			return getRandomCarre();
		default : 
			return getRandomRectangle();
		}
		
}

}
