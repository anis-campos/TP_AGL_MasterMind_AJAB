package devineur;


import java.util.List;
import java.util.Vector;

import jeu.Boule;
import jeu.Boule.Couleurs;
import jeu.TableauBoule;


public class OrdiDevineur  implements Devineur {

	int nbPionRouge, nbPionBlanc, indCoul, nbBoule;
	TableauBoule proposition;

	Vector <TableauBoule> listePossibilite;

	public OrdiDevineur(int nbBoule){
		this.nbPionRouge = 0;
		this.nbPionBlanc = 0;
		this.indCoul = 0;
		this.nbBoule = nbBoule;
		initListePossibilite();
		
		this.proposition = new TableauBoule(this.nbBoule);
		
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
		listePossibilite= new Vector<TableauBoule>();
		
		//initialisation des tableau de nbBoule boules
		for (int i=0;i<nbLigne;i++){
			listePossibilite.add(new TableauBoule(nbBoule));
		}
		
		//inisiatlisation des boules 
		//--------------------------
		for (int i=0;i<nbLigne;i++)
		{
			val_Base_NbCouleur = Integer.decode(Integer.toString(i, nbCouleur));
			for (int n = 0; n<nbBoule; n++){
				listePossibilite.get(i).tab.get(nbBoule-1-n).setCouleur(Couleurs.values()[ ((val_Base_NbCouleur/(int)Math.pow(10, n))) % nbCouleur]);
			}


		}

	}

	
	public void comparerEnlever(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge){
//		Vector <TableauBoule> copieListePossibilite=listePossibilite;
//		for (TableauBoule ligne : listePossibilite){
//				if (!comparer (ligne,tabBoule,nbPionBlanc,nbPionRouge))
//					copieListePossibilite.removeElement(ligne);
//			}
		TableauBoule ligne;
		for (int i=0; i<listePossibilite.size();)
		{
			ligne = listePossibilite.get(i);
			if (!comparer (ligne,tabBoule,nbPionBlanc,nbPionRouge))
				listePossibilite.removeElement(i);
			else 
				i++;
		}
	}
	
	boolean comparer (TableauBoule ligne,TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge){
		
		int nbPB=0, nbPR=0;

		List<Boule> listeBoulePlacement =ligne.tab;
		List<Boule> listeBouleProposition = tabBoule.tab;

		//recherche de pions rouge 
		
		for (int indice=0;indice<nbBoule;){
			if (ligne.tab.get(indice).getCouleur()==tabBoule.tab.get(indice).getCouleur()){
				nbPR++;
				listeBouleProposition.remove(indice);
				listeBoulePlacement.remove(indice);
			}
			else 
				indice++;
		}
		
		//recherche de pions blancs
		for (Boule boule1 : listeBoulePlacement){

			for (Boule boule2 : listeBouleProposition ){
				if (boule1.getCouleur()==boule2.getCouleur()){
					nbPB++;
					listeBouleProposition.remove(boule2);
					break;

				}
			}
			
			
		}
		return nbPB==nbPionBlanc && nbPR==nbPionRouge;
	}
//	public static void main (String []args){
//		int compteur = 0;
//		OrdiDevineur ordi = new OrdiDevineur(4);
//		for (TableauBoule boules : ordi.listePossibilite){
//			for (Boule boule : boules){
//				System.out.print(boule.getCouleur().name()+" " );
//				
//			}
//			compteur++;
//			System.out.println();
//		}
//		
//		System.out.println("Il y a "+compteur+" combinaisons");
//	}


	public TableauBoule proposer(TableauBoule oldProposition) {

		return listePossibilite.get((int)Math.random()*(listePossibilite.size()-1));
	}

	@Override
	public void lirePions(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge) {
		comparerEnlever(tabBoule,nbPionBlanc,nbPionRouge);
	}



}
