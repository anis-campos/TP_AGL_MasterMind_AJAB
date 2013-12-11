/*
 * 
 */
package jeu;

// TODO: Auto-generated Javadoc
/**
 * The Class Boule.
 */
public class Boule implements Cloneable
{

	// definition des couleurs
	/**
	 * The Enum Couleurs.
	 */
	public static enum Couleurs {
		
		/** The Rose. */
		Rose, // 0
		/** The Bleu. */
 Bleu, // 1
		/** The Vert. */
 Vert, // 2
		/** The Jaune. */
 Jaune, // 3
		/** The Violet. */
 Violet, // 4
		/** The Orange. */
 Orange;// 5
	}

	/** The couleur. */
	private Couleurs couleur;

	/**
	 * Sets the couleur.
	 *
	 * @param couleur the new couleur
	 */
	public void setCouleur(Couleurs couleur)
	{
		this.couleur = couleur;
	}

	/**
	 * Gets the couleur.
	 *
	 * @return the couleur
	 */
	public Couleurs getCouleur()
	{
		return couleur;
	}

	/**
	 * Instantiates a new boule.
	 */
	public Boule() {
		this(couleurHasard());
	}

	/**
	 * Instantiates a new boule.
	 *
	 * @param coul the coul
	 */
	public Boule(Couleurs coul) {
		this.couleur = coul;
	}

	// renvoie une couleur au hasard
	/**
	 * Couleur hasard.
	 *
	 * @return the couleurs
	 */
	static Couleurs couleurHasard()
	{
		Couleurs coul;
		coul = Couleurs.values()[(int) (Math.random() * Couleurs.values().length)];
		return coul;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return this.couleur.name();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Boule clone() throws CloneNotSupportedException
	{
		Boule clone = (Boule) super.clone();
		clone.setCouleur(this.couleur);
		return clone;
	}

}
