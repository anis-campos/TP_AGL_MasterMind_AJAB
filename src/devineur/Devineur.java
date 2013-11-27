package devineur;

import jeu.Boule;

public  abstract  interface Devineur {
	public void proposer( Boule []tabBoule);
	public void lirePions(Boule []tabBoule, int nbPionBlanc, int nbPionRouge);
}
