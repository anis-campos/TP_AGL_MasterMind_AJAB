package jeu;
/* Classe qui gere la boucle de jeu
 * 
 * Auteurs : Tous le monde
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import placeur.humainPlaceur;
import placeur.ordiPlaceur;
import placeur.placeur;
import devineur.devineur;
import devineur.humainDevineur;
import devineur.ordiDevineur;

public class jeu{
	//les atributs de classes
	devineur devineur;
	placeur placeur;
	
	
	
	public jeu (/*les parametre*/){
		Properties prop = new Properties();
		 
    	try {
               //load a properties file
    		prop.load(new FileInputStream("config.txt"));
 
            //placeur
            if( prop.getProperty("placeur") == "ordi")
            	placeur=new ordiPlaceur();
            else
            	placeur=new humainPlaceur();
            
            //devineur
    		if (prop.getProperty("devineur")=="ordi")
    			devineur=new ordiDevineur();
    		else 
    			devineur=new humainDevineur();
            
            /* etc */
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
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
		}
	
			
	
			
}
