package devineur;

import java.util.Map;

import jeu.Boule;


public class OrdiDevineur  implements Devineur {
	
	int nbPionRouge, nbPionBlanc, indCoul, nbBoule;
	Boule []proposition;
	Map<String, Integer> malPlace;
	Map<String, Integer> bienPlace;
	
	public OrdiDevineur(int nbBoule){
		this.nbPionRouge = 0;
		this.nbPionBlanc = 0;
		this.indCoul = 0;
		this.nbBoule = nbBoule;
		this.proposition = new Boule[this.nbBoule];
		for (int i = 0; i< this.nbBoule; i++){
			proposition[i] = new Boule();
		}
	}
	
	@Override
	public void proposer(Boule []tabBoule) {
		if (nbPionBlanc < nbBoule){
			for (Boule boule : tabBoule){
				boule = new Boule(Boule.Couleurs.values()[indCoul++]);
			}
		}
		else{
					//Blablabla
		}		
	}

	@Override
	public void lirePions(Boule[] tabBoule, int nbPionBlanc, int nbPionRouge) {
		if (this.nbPionBlanc< nbBoule){
			this.malPlace.put(tabBoule[1].getCouleur().name(), nbPionBlanc);					//name() à vérifier
		this.nbPionBlanc++;
		}
				
	}



}
