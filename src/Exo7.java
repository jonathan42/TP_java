
public class Exo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

	/*	int val = Integer.parseInt(args[0]); // marque le nombre pour l'arret
		
	    int tmp=0;
	    int n=0;
	    
		do {
			
		if (n%2 == 0){
			//pasperimer
		}
		
		 
		++n;
		} while (tmp==val) ;   */
		
		
		                int[] P = new int[10000001]; // cr�ation d'un tr�s grand tableau ^^
		                P[0]=2; // le premier nombre premier est 2
		                int lg = 1; // nombre de nombre premier trouv�.
		                int i=3; // premier nombre qui va �tre test�.
		               
		                for(int j=0;j<lg;j++)
		                {
		                        if((i%P[j])==0) // si le nombre test� est multiple d'un nombre premier.
		                        {
		                                j=0; // r�initialisation du compteur
		                                i = i+2; // pour un nouveau nombre (on exclu les pairs maintenant).
		                        }
		                        else   
		                        {
		                                while(P[j]>Math.sqrt(i)) 
		                                	// si le nombre premier testeur est sup�rieur au carr� du nombre test�, alors il est pr�mier.
		                                {
		                                        P[lg] = i; // enregistrement du nb premier dans le tableau.
		                                        System.out.print(P[lg]);
		                                        System.out.print("est le nombre premier Numero : ");
		                                        System.out.println(lg);
		                                        lg++; // incr�mentation du nombre de premier.
		                                        j=0; // r�initialisation du compteur
		                                        i=i+2; // pour un nouveau nombre..
		                                }
		                        }
		                }

		
	}

}
