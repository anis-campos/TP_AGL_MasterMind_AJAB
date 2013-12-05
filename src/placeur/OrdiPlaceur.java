package placeur;

import jeu.Boule;


public class OrdiPlaceur implements Placeur {

	@Override
	@SuppressWarnings("unused") 
	public void placer(Boule []tabBoule){
		for(Boule boule : tabBoule){
			boule = new Boule();
		}
	}
}

