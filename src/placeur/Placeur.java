/*
 * 
 */
package placeur;

import jeu.TableauBoule;

// TODO: Auto-generated Javadoc
/**
 * l'interface du Placeur.
 */
public abstract interface Placeur
{
	
	/**
	 * Le placeur va choisir les couleurs des boules.
	 *
	 *
	 * @param tabBoule le tableau de boule a placer
	 */
	public void placer(TableauBoule tabBoule);

}
