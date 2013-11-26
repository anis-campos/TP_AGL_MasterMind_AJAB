package jeu;

public class boule {

	//definition des couleurs
	static enum Couleurs {
		Rose,
		Bleu,
		Vert,
		Jaune,
		Violet,
		Orange;	
	}
	
	Couleurs couleur;
	
	public boule ()
	{
		this(couleurHasard());
	}
	
	public boule (Couleurs coul)
	{
		this.couleur=coul;
	}
	
	//renvoie une couleur au hasard
	static Couleurs couleurHasard ()
	{
		Couleurs coul;
		coul=Couleurs.values()[(int)(Math.random()*Couleurs.values().length)];
		return coul ;
		
	}
	
	public String toString (){
		return "La couleur de la boule est : "+this.couleur;
	}
	
	
}
