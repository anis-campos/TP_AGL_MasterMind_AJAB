package jeu;


public class Boule {

	//definition des couleurs
	public static enum Couleurs {
		Rose,
		Bleu,
		Vert,
		Jaune,
		Violet,
		Orange;	
	}
	

	
	private Couleurs couleur;
	
	public void setCouleur(Couleurs couleur) {
		this.couleur = couleur;
	}

	public Couleurs getCouleur() {
		return couleur;
	}

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
		return this.couleur.name();
	}
	
	
}
