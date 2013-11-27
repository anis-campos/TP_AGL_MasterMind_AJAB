package devineur;

import java.util.Vector;

import jeu.Boule;

public  abstract  interface Devineur {
	public void proposer( Vector<Boule> listBoule);
}
