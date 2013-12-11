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
 * The Class OrdiDevineur.
 */
public class OrdiDevineur implements Devineur
{

	/** The nb boule. */
	int nbPionRouge, nbPionBlanc, indCoul, nbBoule;
	
	/** The proposition. */
	TableauBoule proposition;

	/** The liste possibilite. */
	Vector<TableauBoule> listePossibilite;

	/**
	 * Instantiates a new ordi devineur.
	 *
	 * @param nbBoule the nb boule
	 */
	public OrdiDevineur(int nbBoule) {
		this.nbPionRouge = 0;
		this.nbPionBlanc = 0;
		this.indCoul = 0;
		this.nbBoule = nbBoule;
		initListePossibilite();

		this.proposition = new TableauBoule(this.nbBoule);

	}

	/**
	 * Inits the liste possibilite.
	 */
	void initListePossibilite()
	{

		/*
		 * C'est une matrice de nbCouleur^4 lignes et nbBoule colone les lignes
		 * sont dans lordre croissant exemple 0 0 0 0 0 0 0 1 ------- ------- 5
		 * 5 5 4 5 5 5 5
		 */
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
	 * Comparer enlever.
	 *
	 * @param tabBoule the tab boule
	 * @param nbPionBlanc the nb pion blanc
	 * @param nbPionRouge the nb pion rouge
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public void comparerEnlever(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge) throws CloneNotSupportedException
	{

		TableauBoule ligne;
		for (int i = 0; i < listePossibilite.size();) {
			ligne = listePossibilite.get(i);
			if (!comparer(ligne, tabBoule, nbPionBlanc, nbPionRouge)) listePossibilite.remove(i);
			else
				i++;
		}
		System.out.println("fini");
	}

	/**
	 * Comparer.
	 *
	 * @param ligne the ligne
	 * @param tabBoule the tab boule
	 * @param nbPionBlanc the nb pion blanc
	 * @param nbPionRouge the nb pion rouge
	 * @return true, if successful
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	boolean comparer(TableauBoule ligne, TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge) throws CloneNotSupportedException
	{

		int nbPB = 0, nbPR = 0;

		List<Boule> listeBoulePlacement = new ArrayList<Boule>(nbBoule);
		List<Boule> listeBouleProposition = new ArrayList<Boule>(nbBoule);
		for (Boule boule : tabBoule.tab)
			listeBoulePlacement.add(boule.clone());

		for (Boule boule : ligne.tab)
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
	public void lirePions(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge)
	{
		try {
			comparerEnlever(tabBoule, nbPionBlanc, nbPionRouge);
		}
		catch (CloneNotSupportedException e) {
			System.out.println("erreur clone devineur");
		}
	}

}
