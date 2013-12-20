/*
 * 
 */
package devineur;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jeu.Boule;
import jeu.Boule.Couleurs;
import jeu.TableauBoule;

// TODO: Auto-generated Javadoc
/**
 * La Classe OrdiDevineur comporte l'inteligence artificielle de l'ordinateur qui tente de deviner le placement dans le jeu .
 */
public class OrdiDevineur implements Devineur
{

	/** Le nombre de pions rouges. */
	int nbPionRouge;
	
	/** Le nombre de pions blancs. */
	int nbPionBlanc;
	
	/** Le nombre de boules à deviner. */
	int nbBoule;

	/** <p>La liste des possibilitées sous la forme d'une liste de tableau de boules.</p>
	 *  
	 * <p>Plus simplement, c'est une matrice de nbCouleur^NbBoules LIGNES et nbBoule COLOGNE.</br>
	 * les lignes sont dans lordre croissant.</p>
	 * <p>par exemple :
	 *<div style="margin-left:50px;" >0 0 0 0 </div>
	 *<div style="margin-left:50px;" >0 0 0 1 </div>
	 *<div style="margin-left:50px;" >------- </div>
	 *<div style="margin-left:50px;" >------- </div>
	 *<div style="margin-left:50px;" >5 5 5 4 </div>
	 *<div style="margin-left:50px;" >5 5 5 5 </div> </p>
               
	 */
	Vector<TableauBoule> listePossibilite;

	/**
	 * Instanciation d'un nouvel OrdiDevineur.
	 *</br>
	 *La liste des possibilitées est initialisé. 
	 * @param nbBoule le nombre de boules à deviner.
	 * 
	 *@see initListePossibilite
	 */
	public OrdiDevineur(int nbBoule) {
		this.nbPionRouge = 0;
		this.nbPionBlanc = 0;
		this.nbBoule = nbBoule;
		initListePossibilite();

		
	}

	/**
	 * Initialisation de la liste des possibilitées.
	 * 
	 * <p>Pour ce faire, on boucle nbCouleur^nbBoule fois et en initialiser les tableau de boules.<BR>
	 * Ensuite on parcoure la liste en incrementant un indice de ligne 'i', puis en convertie l'indice 
	 * 'i'  en base nbCouleur afin d'initialiser la ligne n°i;<BR></p>
	 * 
	 * <u>example : </u> ( 6 couleur, 4 boules)
	 *<br>passage boucle n° 150 ==> base6(150)= 410 ==> listePossibilite(150)=[0,4,1,0] 
	 */
	void initListePossibilite()
	{

		
		int nbCouleur = Couleurs.values().length;
		int nbLigne = (int) Math.pow(nbCouleur, nbBoule);

		// initialisation du vector
		listePossibilite = new Vector<TableauBoule>();

		// initialisation des tableau de nbBoule boules
		for (int i = 0; i < nbLigne; i++) {
			listePossibilite.add(new TableauBoule(nbBoule));
		}

		// inisiatlisation des boules
		// --------------------------

		for (int i = 0; i < nbLigne; i++) {

			int val_Base_NbCouleur = Integer.decode(Integer.toString(i, nbCouleur));
			for (int n = 0; n < nbBoule; n++) {
				int indice = (val_Base_NbCouleur / (int) (Math.pow(10, n))) % 10;
				listePossibilite.get(i).tab.get(nbBoule - 1 - n).setCouleur(Couleurs.values()[indice]);
			}

		}
	}

	/**
	 * <p>Dans cette méthode en va comparer toutes les possibilite avec la proposition. Si le nombre 
	 * de pions blancs et le nombre de pions rouge entre la possibilite et la proposition
	 * ne sont pas tous les deux egaux a ceux obetenue entre la proposition et le placement
	 * ,on enleve cette possibilité de la liste.</p>
	 * 
	 * 
	 *
	 * @param proposition la proposition faite au jeu.
	 * @param nbPionBlanc nombre de pions blancs entre le placement et la proposition
	 * @param nbPionRouge nombre de pions rouges entre le placement et la proposition
	 * 
	 * @see comparer
	 */
	public boolean comparerEnlever(TableauBoule proposition, int nbPionBlanc, int nbPionRouge)
	{

		TableauBoule ligne;
		for (int i = 0; i < listePossibilite.size();) {
			ligne = listePossibilite.get(i);
			if (!comparer(ligne, proposition, nbPionBlanc, nbPionRouge)) listePossibilite.remove(i);
			else
				i++;
		}
		System.out.println("fini");
		return true;
	}

	/**
	 * Cette méthode va comparer deux tableau de boule.<BR>
	 * 
	 * Elle se base sur un algo glouton en 2 partie :<BR>
	 * <p>1 - <u>Les pions rouges :</u> Une premiere boucle dans laquelle les boules bien placées sont 
	 * 		enlevées des deux tableaux, on incremente le nombre de pions rouges.<BR>
	 * </p>
	 * <p>2 - <u>Les pions blancs :</u> Une deuxieme boucle qui pour chaque boule de la possibilité, 
	 * 		recherche les boules mal placée qui sont enleve de la proposition, on incrémente le nombre de pions blancs.
	 *</p>
	 * Puis on retourne le resultat de la comparaison entre les valeur obtenues et les valeur données.
	 * @param possibilité la possibilité a comparer
	 * @param proposition la proposition faite au jeu
	 * @param nbPionBlanc nombre de pions blancs entre le placement et la proposition
	 * @param nbPionRouge nombre de pions rouges entre le placement et la proposition
	 * @return retourne Vrai s'ils ont le même nombre de pions blanc et rouge, Faux sinon.
	 */
	boolean comparer(TableauBoule possibilité, TableauBoule proposition, int nbPionBlanc, int nbPionRouge) 
	{

		int nbPB = 0, nbPR = 0;

		List<Boule> listeBoulePlacement = new ArrayList<Boule>(nbBoule);
		List<Boule> listeBouleProposition = new ArrayList<Boule>(nbBoule);
		for (Boule boule : proposition.tab)
			listeBoulePlacement.add(boule.clone());

		for (Boule boule : possibilité.tab)
			listeBouleProposition.add(boule.clone());

		// recherche de pions rouge

		for (int indice = 0; indice < listeBoulePlacement.size() && !listeBoulePlacement.isEmpty();) {
			if (listeBoulePlacement.get(indice).getCouleur().name().equals(listeBouleProposition.get(indice).getCouleur().name())) {
				nbPR++;
				listeBouleProposition.remove(indice);
				listeBoulePlacement.remove(indice);
			}
			else
				indice++;
		}

		// recherche de pions blancs
		for (Boule boule1 : listeBoulePlacement) {

			for (Boule boule2 : listeBouleProposition) {
				if (boule1.getCouleur() == boule2.getCouleur()) {
					nbPB++;
					listeBouleProposition.remove(boule2);
					break;

				}
			}

		}
		return nbPB == nbPionBlanc && nbPR == nbPionRouge;
	}

	/* (non-Javadoc)
	 * @see devineur.Devineur#proposer(jeu.TableauBoule)
	 */
	public void proposer(TableauBoule proposition)
	{
		int indice = (int) (Math.random() * (listePossibilite.size() - 1));
		List<Boule> possibilite = listePossibilite.get(indice).tab;
		for (int i = 0; i < proposition.tab.size(); i++)
			proposition.tab.get(i).setCouleur(possibilite.get(i).getCouleur());
	}

	/* (non-Javadoc)
	 * @see devineur.Devineur#lirePions(jeu.TableauBoule, int, int)
	 */
	@Override
	public boolean lirePions(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge)
	{
		if (nbPionBlanc<0 || nbPionBlanc>nbBoule || nbPionRouge<0 || nbPionRouge>nbBoule || nbPionRouge+nbPionBlanc>nbBoule)
			return false;
		return comparerEnlever(tabBoule, nbPionBlanc, nbPionRouge);
	}

}
