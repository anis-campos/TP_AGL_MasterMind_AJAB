package placeur;


import java.util.Vector;
import jeu.Boule;;

public  abstract  interface Placeur {
	public void placer(Vector<Boule> listBoule);
	public void lirePions();
}
