package placeur;

import java.util.Vector;
import jeu.boule;;

public  abstract  interface placeur {
	public void placer(Vector<boule> listBoule);
	public void lirePions();
}
