/*
 * Anis DA SILVA CAMPOS, Julien RATON, Benoit RONGEARD & Antoine BOUQUET
 * 
 * menuPrincipal.java est la classe comportant le main qui lancera l'exécution
 * du programme et affichera le menu et les options
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import jeu.Jeu;

public class menuPrincipal
{

	private static Properties prop = new Properties();

	public static void main(String[] args) throws CloneNotSupportedException
	{

		// Ces deux valeurs représentes des valeurs récupérer par le scanf(),
		// utilisés pour les modifications d'options
		String valeurString;
		int valeurInt;
		//
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		while (menu != 0) {
			do {
				clear();
				System.out.println("\n	    -----------------  Menu MasterMind   --------------- ");
				System.out.println("	   |	1 : Jouer                                       |");
				System.out.println("	   |	2 : Options                                     |");
				System.out.println("	   |	3 : Crédits                                     |");
				System.out.println("	    ---------------------------------------------------- ");
				System.out.println("	   |	0 : Quitter	                                |");
				System.out.println("	    ---------------------------------------------------- ");
				System.out.println("\nVeuillez saisir votre commande : ");
				menu = scanfInt(sc);
			} while (menu < 0 || menu > 3);

			switch (menu) {
				case 0:
					System.out.println("Programme terminé !! ");
					break;
				case 1:
					Jeu jeu = new Jeu();
					jeu.run();
					break;
				case 2:
					menu = -1;
					try {
						prop.load(new FileInputStream("src/config.txt"));
						while (menu != 0) {

							do {
								clear();
								System.out.println("\n	    ----------------  Options MasterMind   ------------- ");
								System.out.println("	   |  	1 : Mode de jeu :                               |");
								System.out.print("           |         -> Placeur : " + prop.getProperty("placeur") + "                        ");
								if (prop.getProperty("placeur").compareTo("Ordi") == 0) System.out.print("  ");
								System.out.println("|");
								System.out.print("           |         -> Devineur : " + prop.getProperty("devineur") + "                       ");
								if (prop.getProperty("devineur").compareTo("Ordi") == 0) System.out.print("  ");
								System.out.println("|");
								System.out.println("	   |	2 : Nombre de boules : " + prop.getProperty("nbBoule") + "                        |");
								System.out.println("	   |	3 : Sauvegarder les modifications               |");
								System.out.println("	    ---------------------------------------------------- ");
								System.out.println("	   |	0 : Retour                                      |");
								System.out.println("	    ---------------------------------------------------- ");
								System.out.println("\nVeuillez saisir votre commande : ");

								menu = scanfInt(sc);

							} while (menu < 0 || menu > 3);

							switch (menu) {
								case 1:
									System.out.println("Placeur (Ordi = 'O', Humain = 'H') = ");
									valeurString = scanf(sc);
									if (valeurString.compareTo("O") == 0) prop.setProperty("placeur", "Ordi");
									else if (valeurString.compareTo("H") == 0) prop.setProperty("placeur", "Humain");
									else {
										System.out.println("Ce n'est pas une bonne valeur..");
										try {
											Thread.sleep(3000);
										}
										catch (InterruptedException e) {
											e.getMessage();
										}
									}
									System.out.println("Devineur (Ordi = 'O', Humain = 'H') = ");
									valeurString = scanf(sc);
									if (valeurString.compareTo("O") == 0) prop.setProperty("devineur", "Ordi");
									else if (valeurString.compareTo("H") == 0) prop.setProperty("devineur", "Humain");
									else {
										System.out.println("Ce n'est pas une bonne valeur..");
										try {
											Thread.sleep(3000);
										}
										catch (InterruptedException e) {
											e.getMessage();
										}
									}
									break;
								case 2:
									clear();
									valeurInt = -1;
									do {
										System.out.println("Nombre de boules ? (3, 4 et 5 autorisé) ");
										valeurInt = scanfInt(sc);
										if (valeurInt >= 3 && valeurInt <= 5) prop.setProperty("nbBoule", Integer.toString(valeurInt));
										else {
											System.out.println("Ce n'est pas une bonne valeur..");
											try {
												Thread.sleep(3000);
											}
											catch (InterruptedException e) {
												e.getMessage();
											}
										}
									} while (valeurInt < 3 || valeurInt > 5);
									break;
								case 3:
									prop.store(new FileOutputStream("src/config.txt"), null);
									clear();
									System.out.println("Options sauvegardées !");
									try {
										Thread.sleep(3000);
									}
									catch (InterruptedException e) {
										e.getMessage();
									}
									break;
								default:
									break;
							}
						}
					}
					catch (IOException ex) {
						ex.printStackTrace();
					}
					menu = -1;
					break;
				case 3:
					clear();
					System.out.println("Créateur : Antoine Bouquet, Anis Da Silva Campos, Julien Raton, Benoit Rongeard");
					System.out.println("\nCopyright © - Tous droits réservés");
					System.out.println("parce que c'est classe de mettre ça quand même.");
					try {
						Thread.sleep(6000);
					}
					catch (InterruptedException e) {
						e.getMessage();
					}
					break;
				default:
					break;
			}

		}
		sc.close();

	}

	static void clear()
	{
		for (int i = 0; i < 20; i++)
			System.out.print("\n");
	}

	static int scanfInt(Scanner sc)
	{
		int menu = -1;
		String menuString = scanf(sc);
		try {
			menu = Integer.decode(menuString);
		}
		catch (NumberFormatException e) {
			e.getMessage();
		}

		return menu;
	}

	static String scanf(Scanner sc)
	{
		String str;
		str = sc.nextLine();
		return str;
	}

}
