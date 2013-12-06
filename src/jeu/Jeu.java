package jeu;
/* Classe qui gere la boucle de jeu
 * 
 * Auteurs : Tous le monde
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import placeur.HumainPlaceur;
import placeur.OrdiPlaceur;
import placeur.Placeur;
import devineur.Devineur;
import devineur.HumainDevineur;
import devineur.OrdiDevineur;

public class Jeu{
	//les atributs de classes
	Devineur devineur;
	Placeur placeur;
	int nbBoule;
	final int NB_ESSAI = 50;
	TableauBoule placement , proposition;
	boolean running=true;

	public Jeu (){
		Properties prop = new Properties();

		try {


			//load a properties file
			prop.load(new FileInputStream("src/config.txt"));

			this.nbBoule = Integer.decode( prop.getProperty("nbBoules"));
			placement=new TableauBoule(nbBoule);
			proposition=new TableauBoule(nbBoule);
			//placeur
			if( prop.getProperty("placeur") == "ordi")
				placeur=new OrdiPlaceur();
			else
				placeur=new HumainPlaceur();

			//devineur

			if (prop.getProperty("devineur")=="ordi")
				devineur=new OrdiDevineur(nbBoule);		//attention
			else 
				devineur=new HumainDevineur();


			/* etc */

		} catch (IOException ex) {
			System.out.println("Erreur - Impossible de lire le fichier \"src//config.txt\" !!");
		}
	}



	public void run (){
		//boucle qui se termine avec "fin" ou "nbessai"
		//on demande au "devineur" de proposer un ensemble
		//incrementer "nbessai"

		//on teste le resultat
		//si c'est faux
		// on lui dit les pions
		//si c'est juste "fin"= true
		//fin de test
		//fin de boucle
		int compteur=0;
		placeur.placer(placement);
		while (running && compteur<NB_ESSAI) {
			compteur++;
			devineur.proposer(proposition);
			verification();
		}
		if (compteur<NB_ESSAI)
			System.out.println("Bravo vous avez gagné!!!");
		else 
			System.out.println("Désolé, vous avez perdu!!!");
		System.out.println("Appuyer sur entrer pour continuer ...");
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		keyIn.nextLine();
	}


	void verification (){
		int nbPionBlanc=0, nbPionRouge=0;

		List<Boule> listeBoulePlacement = placement.tab;
		List<Boule> listeBouleProposition = proposition.tab;

		//recherche de pions rouge 
		
		for (int indice=0;indice<nbBoule;indice++){
			if (placement.tab.get(indice).getCouleur()==proposition.tab.get(indice).getCouleur()){
				nbPionRouge++;
				listeBouleProposition.remove(indice);
				listeBoulePlacement.remove(indice);
			}
		}
		
		//si nbBoule pions rouge il a gagné et le jeu s'arrete
		if (nbPionRouge==nbBoule){
			running=false;
			return;
		}
		//recherche de pions blancs
		for (Boule boule1 : listeBoulePlacement){

			for (Boule boule2 : listeBouleProposition ){
				if (boule1.getCouleur()==boule2.getCouleur()){
					nbPionBlanc++;
					listeBouleProposition.remove(boule2);
					break;

				}
			}
		}
		
		System.out.println("Nombre de pion blanc : "+nbPionBlanc+"\nNombre de pion rouge :"+nbPionRouge);
		
		//envoyer les pion au devineur
		devineur.lirePions(proposition, nbPionBlanc, nbPionRouge);
	}



}
