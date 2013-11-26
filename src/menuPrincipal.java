/*Anis DA SILVA CAMPOS, Julien RATON, Benoit RONGEARD & Antoine BOUQUET
 * 
 * menuPrincipal.java est la classe comportant le main qui lancera l'exécution du programme et affichera le menu et les options*/

import java.util.*;


public class menuPrincipal{

	private static Scanner sc;

	public static void main(String[] args) {
		int menu = -1;
		String menuString;
		sc = new Scanner(System.in);
		while (menu != 0){
			System.out.println("MENU MASTERMIND\n\n0. Quitter\n1. Jouer au Master Mind\n2. Options\nChoix : ");
			menuString = sc.nextLine();
			try{
				menu = Integer.decode(menuString);
			}
			catch(NumberFormatException e){e.getMessage();}
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
		System.out.println("coucou");
		clear();
	}
	
	public static void clear(){
		try{
			Runtime.getRuntime().exec("clear") ;
			System.out.println("");
		}
		catch(Exception e){
			e.getMessage();
		};
	}
		

	

}
