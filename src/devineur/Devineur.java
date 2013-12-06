package devineur;

import jeu.TableauBoule;

public  abstract  interface Devineur {
	public TableauBoule proposer( TableauBoule oldProposition);
	public void lirePions(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge);
}
