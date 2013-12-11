package jeu;

public class Boule implements Cloneable
{

	// definition des couleurs
	public static enum Couleurs {
		Rose, // 0
		Bleu, // 1
		Vert, // 2
		Jaune, // 3
		Violet, // 4
		Orange;// 5
	}

	private Couleurs couleur;

	public void setCouleur(Couleurs couleur)
	{
		this.couleur = couleur;
	}

	public Couleurs getCouleur()
	{
		return couleur;
	}

	public Boule() {
		this(couleurHasard());
	}

	public Boule(Couleurs coul) {
		this.couleur = coul;
	}

	// renvoie une couleur au hasard
	static Couleurs couleurHasard()
	{
		Couleurs coul;
		coul = Couleurs.values()[(int) (Math.random() * Couleurs.values().length)];
		return coul;

	}

	public String toString()
	{
		return this.couleur.name();
	}

	public Boule clone() throws CloneNotSupportedException
	{
		Boule clone = (Boule) super.clone();
		clone.setCouleur(this.couleur);
		return clone;
	}

}
