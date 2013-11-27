package placeur;

import jeu.Boule;


public class OrdiPlaceur implements Placeur {

	@Override
	public void placer(Boule []tabBoule){
		// TODO Auto-generated method stub
		for(int i=0; i < tabBoule.length ; i++){
			tabBoule[i] = new Boule();
		}
	}
}

