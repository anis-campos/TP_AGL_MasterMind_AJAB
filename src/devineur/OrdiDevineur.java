package devineur;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import com.sun.corba.se.pept.transport.InboundConnectionCache;

import jeu.Boule;
import jeu.Boule.Couleurs;


public class OrdiDevineur  implements Devineur {

	int nbPionRouge, nbPionBlanc, indCoul, nbBoule;
	Boule []proposition;
	Vector<Couleurs> couleurJuste;
	boolean recherche=true, premierePermutation=false;

	Vector <Boule[]> listePossibilite;

	public OrdiDevineur(int nbBoule){
		this.nbPionRouge = 0;
		this.nbPionBlanc = 0;
		this.indCoul = 0;
		this.nbBoule = nbBoule;
		initListePossibilite();
		couleurJuste= new Vector<Couleurs>();
		this.proposition = new Boule[this.nbBoule];
		for (int i = 0; i< this.nbBoule; i++){
			proposition[i] = new Boule();
		}
	}

	void initListePossibilite() {

		/*C'est une matrice de nbCouleur^4 lignes et nbBoule colone
		 * les lignes sont dans lordre croissant
		 * example
		 * 	0 0 0 0
		 *  0 0 0 1
		 *  -------
		 *  -------
		 *  5 5 5 4
		 *  5 5 5 5
		 * */
		int nbCouleur = Couleurs.values().length;
		int nbLigne = (int) Math.pow(nbCouleur,nbBoule);
		int val_Base_NbCouleur;
		
		//initialisation du vector
		listePossibilite= new Vector<Boule[]>();
		
		//initialisation des tableau de nbBoule boules
		for (int i=0;i<nbLigne;i++){
			listePossibilite.add(new Boule[nbBoule]);
		}
		
		//inisiatlisation des boules 
		//--------------------------
		for (int i=0;i<nbLigne;i++)
		{
			val_Base_NbCouleur = Integer.decode(Integer.toString(i, nbCouleur));
			for (int n = 0; n<nbBoule; n++){
				listePossibilite.get(i)[nbBoule-1-n] = new Boule(Couleurs.values()[ ((val_Base_NbCouleur/(int)Math.pow(10, n))) % nbCouleur]);
			}


		}

	}

	public static void main (String []args){
		int compteur = 0;
		OrdiDevineur ordi = new OrdiDevineur(4);
		for (Boule[] boules : ordi.listePossibilite){
			for (Boule boule : boules){
				System.out.print(boule.getCouleur().name()+" " );
				
			}
			compteur++;
			System.out.println();
		}
		
		System.out.println("Il y a "+compteur+" combinaisons");
	}

	@Override
	public Boule[] proposer(Boule []oldProposition) {
		if (couleurJuste.size() < nbBoule ){

			for (Boule boule : proposition){
				boule = new Boule(Boule.Couleurs.values()[indCoul]);
			}
			indCoul++;
		}
		else{
			recherche=false;
			if (!premierePermutation){
				int index=0;
				for ( Boule boule : proposition)
					boule=new Boule(couleurJuste.get(index++));
				premierePermutation=true;
			}
			else {
				//Blablabla
			}
		}	

		return proposition;
	}

	@Override
	public void lirePions(Boule[] tabBoule, int nbPionBlanc, int nbPionRouge) {
		if (recherche){
			if ( nbPionRouge > 0 )
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
