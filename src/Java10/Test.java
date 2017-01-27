package Java10;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p1 = new Point(5, 2);
		System.out.println(p1);
		System.out.println(p1.getX());
		System.out.println(p1.getY());

		Rond rd1 = new Rond(p1, 4);
		rd1.affiche();

		Rectangle rt1 = new Rectangle(new Point(10, 3), 2, 6);
		rt1.affiche();

		rd1 = FigureUtil.getRandomRond();
		rd1.affiche();

		rt1 = FigureUtil.getRandomRectangle();
		rt1.affiche();

		Carre c = new Carre(p1, 5);
		c.affiche();

		// Object o = new Rectangle(p1, 5, 12);
		// System.out.println(o.getClass());

		Point p2 = new Point2(5, 2);
		Point p3 = new Point(4, 3);

		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));

		// test exo de java 14
		Figure f1 = FigureUtil.getRandomFigure();
		f1.affiche();

		Figure f2 = FigureUtil.getRandomFigure();
		f2.affiche();

		Figure f3 = FigureUtil.getRandomFigure();
		f3.affiche();
		
		
		// test exo de java 15

		Segment s1 = new Segment( new Point(20, 20), 5 , true );
		s1.affiche();
		Segment s2 = new Segment( new Point(20, 20), 5 , false );
		s2.affiche();
		
		System.out.println(rd1.surface());
		System.out.println(rt1.surface());
		
		
		Surfacable sr1 = FigureUtil.getRandomSurfacable();
		System.out.println(sr1 + " -> " + sr1.surface());
		
		Surfacable sr2 = FigureUtil.getRandomSurfacable();
		System.out.println(sr2 + " -> " + sr2.surface());
		
		Surfacable sr3 = FigureUtil.getRandomSurfacable();
		System.out.println(sr3 + " -> " + sr3.surface());
	}

}
