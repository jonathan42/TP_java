package Java10;

import java.io.Serializable;

public enum Couleur implements Serializable {

	Rouge('R'),Vert('V'),Bleu('B'),Jaune('J'),Noir('N');
	
	private char code;
	
	public static Couleur getCouleurDefaut(){
		return Couleur.Noir;
	}
	
	private Couleur(char c){
		this.code=c;
	}
	
	public char getCode(){
		return this.code;
	}
}
