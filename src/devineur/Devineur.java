/*
 * 
 */
package devineur;

import jeu.TableauBoule;


// TODO: Auto-generated Javadoc
/**
 * L'interface qui drecrit les m�thodes du devineur.
 * @author Anis 
 * @author Julien
 */
public abstract interface Devineur
{
	
	/**
	 * Le devineur va au choix modifier la couleur des boules de la proposition.
	 *
	 * @param proposition  proposition pr�c�dente, � modifier.
	 */
	public void proposer(TableauBoule proposition);

	/**
	 * Permet au au devineur de lire les pions rouges et les pions blancs.
	 * On lui transmet son ancienne proposition, pour qu'il l'ai plus facilement
	 *
	 * @param proposition  La proposition pr�c�dente
	 * @param nbPionBlanc  Le nombre de pion blanc, et donc, de couleur mal plac�e
	 * @param nbPionRouge  Le nombre de pion rouge, et donc, de couleur bien plac�e
	 */
	public void lirePions(TableauBoule proposition, int nbPionBlanc, int nbPionRouge);
}
