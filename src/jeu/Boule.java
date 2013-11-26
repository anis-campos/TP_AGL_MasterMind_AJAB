package jeu;

public class Boule {

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
	
	public Boule ()
	{
		this(couleurHasard());
	}
	
	public Boule (Couleurs coul)
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
