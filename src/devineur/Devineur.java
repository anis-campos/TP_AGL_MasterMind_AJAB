package devineur;

import jeu.TableauBoule;

public  abstract  interface Devineur {
	public void proposer( TableauBoule proposition);
	public void lirePions(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge);
}
