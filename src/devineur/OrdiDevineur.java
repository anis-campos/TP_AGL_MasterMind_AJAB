package devineur;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import jeu.Boule;
import jeu.Boule.Couleurs;


public class OrdiDevineur  implements Devineur {

	int nbPionRouge, nbPionBlanc, indCoul, nbBoule;
	Boule []proposition;
	Vector<Couleurs> couleurFausse;
	Vector<Couleurs> couleurJuste;
	boolean recherche=true, premierePermutation=false;
	/*
	 * faire un tableau de couleur presente dans le placement
	 *      et tableau de couleur non presente dans le placement
	 * 
	 * */
	public OrdiDevineur(int nbBoule){
		this.nbPionRouge = 0;
		this.nbPionBlanc = 0;
		this.indCoul = 0;
		this.nbBoule = nbBoule;
		couleurFausse= new Vector<Couleurs>();
		couleurJuste= new Vector<Couleurs>();
		this.proposition = new Boule[this.nbBoule];
		for (int i = 0; i< this.nbBoule; i++){
			proposition[i] = new Boule();
		}
	}

	@Override
	public Boule[] proposer(Boule []oldProposition) {
		if (nbPionRouge < nbBoule && couleurFausse.size()<Couleurs.values().length-nbBoule){
			
			for (Boule boule : proposition){
				boule = new Boule(Boule.Couleurs.values()[indCoul]);
			}
			indCoul++;
		}
		else{
			recherche=false;
			if (!premierePermutation){
				initPermutation();
				premierePermutation=true;
			}
			else {
			//Blablabla
			}
		}	
		
		return proposition;
	}
	
	@SuppressWarnings("unused")
	void initPermutation(){
		int index=0;
		if (couleurFausse.size()==Couleurs.values().length-nbBoule)
		{
			
			List<Couleurs> couleurAPermuter = Arrays.asList(Couleurs.values());
			for ( Couleurs coul : couleurFausse)
				couleurAPermuter.remove(coul);
			
			for ( Boule boule : proposition){
				boule=new Boule(couleurAPermuter.get(index++));
			}
		}
		else
		{
			for ( Boule boule : proposition){
				boule=new Boule(couleurJuste.get(index++));
			} 
		}
	}
	
	@Override
	public void lirePions(Boule[] tabBoule, int nbPionBlanc, int nbPionRouge) {
		if (recherche){
			if (nbPionBlanc == 0 && nbPionRouge==0){
				this.couleurFausse.add(tabBoule[1].getCouleur());
			}
			else if ( nbPionRouge > 0 )
			{
				this.nbPionRouge+=nbPionRouge;
				for (int i=0; i<nbPionRouge;i++)
					couleurJuste.add(tabBoule[1].getCouleur());
			}
		}
		else{
			
		}
	}



}
