package jeu;
/* Classe qui gere la boucle de jeu
 * 
 * Auteurs : Tous le monde
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	Boule []placement;
	Boule []proposition;
	boolean running=true;
	
	public Jeu (){
		Properties prop = new Properties();
		 
    	try {
    		
    		//load a properties file
    		prop.load(new FileInputStream("src/config.txt"));
    		this.nbBoule = Integer.decode( prop.getProperty("nbBoules"));
    		placement=new Boule[nbBoule];
    		proposition=new Boule[nbBoule];
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
    		System.out.println("Erreure - Impossible de lire le fichier \"src//config.txt\" !!");;
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
			placeur.placer(placement);
			while (running) {
				devineur.proposer(proposition);
				verification();
			}
		}
	
		
	void verification (){
		
	}
			
	
			
}
