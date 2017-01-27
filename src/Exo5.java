
public class Exo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// methode 1
		int val =0; 
		
		while (val < Integer.parseInt(args[0])){
			System.out.println(val);
			++val;
		}
		
		System.out.println("la 2eme methode");
		// methode 2
		val=0;
		do {
			System.out.println(val); 
			++val;
		}
		while (val < Integer.parseInt(args[0]));
			
			
		
	}

}
