
public class Exo4 {

	public static void main(String args[]) {
		// TODO Auto-generated method stub

		float val = Float.parseFloat(args[0]);
				
		if ( val <1000){
			System.out.println("la remise est O %");
			System.out.println(" le prix est de "+val);
		}
		else if(val >=1000 && val<2000){
			System.out.println("la remise est 1 % : "+val*0.01);
			System.out.println(" le prix est de "+(val-(+val*0.01)));

		}
		else if( val>=2000 && val<5000){
			System.out.println("la remise est 3 % : "+val*0.03);
			System.out.println(" le prix est de "+(val-(+val*0.03)));

		}
		else {
			System.out.println("la remise est 5 % : "+val*0.05);
			System.out.println(" le prix est de "+(val-(+val*0.05)));

		}
		
		
		int val2 =  Integer.parseInt(args[1]);

		switch(val2) {
		
			case 1 : 
				System.out.println("Dans le petit sac");
				break;
		
			case 2 :
				System.out.println("Dans le sac moyen");
				break;
				
			default : 
				System.out.println("Dasn le grand sac");
				break;
		}
		
	}

}
