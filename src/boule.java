
public class boule {
	
	static enum Couleurs {
		Rose,
		Bleu,
		Vert,
		Jaune,
		Violet,
		Orange,	
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
	
	static Couleurs couleurHasard ()
	{
		Couleurs coul;
		coul=Couleurs.values()[(int)(Math.random()*Couleurs.values().length)];
		return coul ;
		
	}
	
}
