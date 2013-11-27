/*Anis DA SILVA CAMPOS, Julien RATON, Benoit RONGEARD & Antoine BOUQUET
 * 
 * menuPrincipal.java est la classe comportant le main qui lancera l'exécution du programme et affichera le menu et les options*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import jeu.Jeu;


public class menuPrincipal{


	public static void main(String[] args) {
		int menu = -1;
		String menuString;
		Scanner sc = new Scanner(System.in);
		while (menu != 0){
			do {
				System.out.println("\n	    -----------------  Menu MasterMind   --------------- ");
				System.out.println("	   |	1 : jouer                                       |");
				System.out.println("	   |	2 : option                                      |");
				System.out.println("	    ---------------------------------------------------- ");
				System.out.println("	   |	0 : Terminer                                    |");
				System.out.println("	    ---------------------------------------------------- ");
				System.out.println("\nVeuillez saisir votre commande : ");

				menuString = sc.nextLine();
				try{
					menu = Integer.decode(menuString);
				}
				catch(NumberFormatException e){e.getMessage();}
			}while(menu < 0 || menu > 2);

			switch(menu){
				case 0:
					System.out.println("Programme terminé !! ");
				case 1 :
					Jeu jeu = new Jeu();
					jeu.run();
					break;
				case 2 :
					options();
					break;
				default :
					break;
			}

			clear();
		}
		sc.close();

	}


	static void options(){
		System.out.println("coucou");
		
		Properties prop = new Properties();
		 
    	try {
    		//set the properties value
    		
    		prop.setProperty("database", "localhost");
    		prop.setProperty("dbuser", "mkyong");
    		prop.setProperty("dbpassword", "password");
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("src/config.txt"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    
		clear();
	}

	static void clear()
	{
		for (int i=0;i<15;i++)
			System.out.print("\n");
	}




}
