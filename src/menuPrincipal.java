/*Anis DA SILVA CAMPOS, Julien RATON, Benoit RONGEARD & Antoine BOUQUET
 * 
 * menuPrincipal.java est la classe comportant le main qui lancera l'exécution du programme et affichera le menu et les options*/

import java.util.*;


public class menuPrincipal{

	private static Scanner sc;

	public static void main(String[] args) {
		int menu = -1;
		sc = new Scanner(System.in);
		while (menu != 0){
			System.out.println("MENU MASTERMIND\n\n1. Jouer au Master Mind\n2. Options\nChoix : ");
			menu = Integer.parseInt(sc.nextLine());
			while(menu < 1 || menu > 2){
				System.out.println("MENU MASTERMIND\n\n1. Jouer au Master Mind\n2. Options\nChoix : ");
				menu = Integer.parseInt(sc.nextLine());
			}
			
			switch(menu){
				case 1 :
					break;
				case 2 :
					options();
					break;
			}
		}
	}
	
	
	public static void options(){
		clear();
		System.out.println("coucou");
	}
	
	public static void clear(){
		try{
			 Runtime.getRuntime().exec("cls");
		}
	    catch(Exception e){
	       System.out.println("Erreur lors de l'effacement de l'écran.");
	    }
	}
		

	

}
