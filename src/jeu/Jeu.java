package jeu;

/*
 * Classe qui gere la boucle de jeu
 * 
 * Auteurs : Tous le monde
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import placeur.HumainPlaceur;
import placeur.OrdiPlaceur;
import placeur.Placeur;
import devineur.Devineur;
import devineur.HumainDevineur;
import devineur.OrdiDevineur;

public class Jeu
{
	// les atributs de classes
	Devineur devineur;
	Placeur placeur;
	int nbBoule;
	final int NB_ESSAI = 10;
	TableauBoule placement, proposition;
	boolean running = true;

	public Jeu() {
		Properties prop = new Properties();

		try {

			prop.load(new FileInputStream("src/config.txt"));

			this.nbBoule = Integer.decode(prop.getProperty("nbBoule"));
			placement = new TableauBoule(nbBoule);
			proposition = new TableauBoule(nbBoule);

			// placeur
			if (prop.getProperty("placeur").equals("Ordi")) placeur = new OrdiPlaceur();
			else
				placeur = new HumainPlaceur();

			// devineur

			if (prop.getProperty("devineur").equals("Ordi")) devineur = new OrdiDevineur(nbBoule);
			else
				devineur = new HumainDevineur();

		}
		catch (IOException ex) {
			System.out.println("Erreur - Impossible de lire le fichier \"src//config.txt\" !!");
		}
	}

	public void run() throws CloneNotSupportedException
	{
		int compteur = 0;
		placeur.placer(placement);

		while (running && compteur < NB_ESSAI) {
			compteur++;
			devineur.proposer(proposition);
			System.out.println("\n\nVous avez proposé la composition " + proposition.tab);
			verification();
		}
		if (compteur < NB_ESSAI) System.out.println("Bravo vous avez gagné!!!\n\nVous avez trouvé la composition " + placement.tab + " en "
				+ compteur + " coups !!!");
		else
			System.out.println("Désolé, vous avez perdu!!!");

		System.out.println("Appuyer sur entrer pour continuer ...");
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		keyIn.nextLine();
	}

	void verification() throws CloneNotSupportedException
	{
		int nbPionBlanc = 0, nbPionRouge = 0;

		List<Boule> listeBoulePlacement = new ArrayList<Boule>(nbBoule);
		List<Boule> listeBouleProposition = new ArrayList<Boule>(nbBoule);
		for (Boule boule : placement.tab)
			listeBoulePlacement.add(boule.clone());

		for (Boule boule : proposition.tab)
			listeBouleProposition.add(boule.clone());

		// recherche de pions rouge

		for (int indice = 0; indice < listeBoulePlacement.size() && !listeBoulePlacement.isEmpty();) {
			if (listeBoulePlacement.get(indice).getCouleur().name().equals(listeBouleProposition.get(indice).getCouleur().name())) {
				nbPionRouge++;
				listeBouleProposition.remove(indice);
				listeBoulePlacement.remove(indice);
			}
			else
				indice++;
		}

		// si nbBoule pions rouge il a gagné et le jeu s'arrete
		if (nbPionRouge == nbBoule) {
			running = false;
			return;
		}
		// recherche de pions blancs
		for (Boule boule1 : listeBoulePlacement) {

			for (Boule boule2 : listeBouleProposition) {
				if (boule1.getCouleur() == boule2.getCouleur()) {
					nbPionBlanc++;
					listeBouleProposition.remove(boule2);
					break;

				}
			}
		}

		System.out.println("Nombre de pion blanc : " + nbPionBlanc + "\nNombre de pion rouge :" + nbPionRouge);

		// envoyer les pion au devineur
		devineur.lirePions(proposition, nbPionBlanc, nbPionRouge);
	}

}
