package devineur;

import jeu.Boule;

public  abstract  interface Devineur {
	public Boule[] proposer( Boule []oldProposition);
	public void lirePions(Boule []tabBoule, int nbPionBlanc, int nbPionRouge);
}
