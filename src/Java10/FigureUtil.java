package Java10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FigureUtil {

	private static final int x_max = 99;
	private static final int x_min = 0;

	private static final int y_max = 99;
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
	
	private static Couleur getRandomCouleur() {
		int max = Couleur.values().length;
		int i = getRandomInteger(0, max-1);
		return Couleur.values()[i];
	}

	public static Rond getRandomRond() {

		int rayon = getRandomInteger(size_min / 2, size_max / 2);
		Point p = getRandomPoint(x_min, x_max, y_min, y_max);
		Couleur c = getRandomCouleur();
		return new Rond(c, p, rayon);

	}

	public static Rectangle getRandomRectangle() {

		int L = getRandomInteger(size_min, size_max);
		int H = getRandomInteger(size_min, size_max);
		Point p = getRandomPoint(x_min, x_max, y_min, y_max);
		Couleur c = getRandomCouleur();
		return new Rectangle(c,p, L, H);

	}

	public static Carre getRandomCarre() {
		int cote = getRandomInteger(size_min, size_max);
		Point basGauche = getRandomPoint(x_min, x_max, y_min, y_max);
		 Couleur couleur = getRandomCouleur();
		Carre carre = new Carre(couleur,basGauche, cote);
		// ids.put(carre.getId(), carre);
		return carre;
	}

	public static Segment getRandomSegment() {
		Point debut = getRandomPoint(x_min, x_max, y_min, y_max);
		int longueur = getRandomInteger(size_min, size_max);
		boolean horizontal = getRandomInteger(0, 1) > 0.5; // pour le test

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

	public static Collection<Figure> genere(int nb) {
		Collection<Figure> f = new ArrayList<Figure>();
		for (int i = 0; i <= nb; i++) {
			f.add(getRandomFigure());
		}
		return f;
	}

	// fonction avec entre variable
	public static int somme(int... valeurs) { // c'est une ellipse
		int s = 0;
		for (int v : valeurs) {
			s += v;
		}
		return s;
	}

	public static Collection<Point> getPoints(Figure... figures) {
		// Il peut y avoir des doublons

		Collection<Point> points = new ArrayList<Point>();

		for (Figure f : figures) {
			points.addAll(f.getPoints());
		}

		return points;
		
	
	}

	public static Surfacable getRandomSurfacable() {
		int choix = getRandomInteger(0, 2);
		switch (choix) {
		case 0:
			return getRandomRond();
		case 1:
			return getRandomCarre();
		default:
			return getRandomRectangle();
		}

	}

	// il faut mieux utilise un Optional pour les retour null
	public static Optional<Figure> getFigureEn(Point p, Dessin d) {
		// iterator car on modifi pas la collection
		/*Iterator<Figure> iterator = d.getFigures().iterator();
		while (iterator.hasNext()) {
			Figure f = iterator.next();
			if (f.couvre(p)) {
				return Optional.of(f);
			}
		}
		return Optional.empty();*/
		
		return d.getFigures().stream()
				//.parallel()
				.filter(f -> f.couvre(p))
				.findAny();
	}

	//
	public static List<Object> trieProcheOrigine(Dessin dessin) {
		return dessin.getFigures().stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public static List<Surfacable> trieDominant(Dessin dessin) {
		return dessin.getFigures().stream()
				.filter(f -> f instanceof Surfacable)
				.map(x ->(Surfacable) x)
				.sorted( (f1,f2) -> f1.surface() > f2.surface() ? -1 :1)
				.collect(Collectors.toList());
						
		// return dessin.getFigures().stream()
		//		.filter(f -> f instanceof Surfacable)
		//		.map(x -> (Surfacable) x)
		//		.sorted((f1, f2) -> f1.surface() > f2.surface() ? -1 : 1)
		//		.collect(Collectors.toList());
	}
	
		public static void imprime(Dessin d) throws IOException {
			
			    // on crée un fichier temp
				File file = File.createTempFile("monDessin", ".dessin");
				
				PrintWriter sortie = new PrintWriter(new FileOutputStream(file));
				
				// pour le dession on ouvre un stream et ont parcours les figures 
				// qu'on imprime dasn la sorti
				d.getFigures().stream().forEach(f -> sortie.println(f));	
				
				// on genere un séparateur 
				
				for(int x=x_min;x<x_max;x++){
					sortie.print("=");
					//System.out.print("=");
				}
				sortie.println();
				//System.out.println();
				
				// on parcour les points Y et X 
				for(int y=y_min;y<y_max;y++){
					for(int x=x_min;x<x_max;x++){
						Optional<Figure> figure = getFigureEn(new Point(x,y),d);
						// si present on  imprime le code couleur
						if(figure.isPresent()){
							sortie.println(figure.get().getCouleur().getCode());
							//System.out.print(figure.get().getCouleur().getCode());
						} else {
							// sinon on mais un espace
							sortie.println(" ");
							//System.out.print(" ");
						}
					}
					sortie.println();
					//System.out.println();
				}
				System.out.println("Impression sous " + file.getAbsolutePath());
				sortie.close();
			}
		
			
			public static void sauvegarde(Dessin d) throws IOException {
				// creation d'un fichier .save
				File file = File.createTempFile("monDessin", ".save");
				// ouverture du flux 
				ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(file));
				sortie.writeObject(d); // ecrrit dans le flux le dessin
				System.out.println("Sauvegarde sous " + file.getAbsolutePath()); // imprime systeme
				sortie.close(); // ferme le flux
			}
			
			public static Dessin charge(String filename) throws IOException, ClassNotFoundException {
				Dessin dessin;
				
				try {
					// ouvre le flux du fichier 
					ObjectInputStream enter = new ObjectInputStream(new FileInputStream(filename));
					//met dans dessin l'objet casté en dessin lu
					dessin = (Dessin) enter.readObject();
					enter.close();
				} catch (FileNotFoundException e) {
					System.out.println("Fichier non trouvé : " + e.getMessage());
					// si fichier non trouvé  il crée un dessin defaut
					dessin = new Dessin();
				}
				return dessin; // return dessin
			}

}
