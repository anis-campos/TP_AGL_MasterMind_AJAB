package placeur;


import jeu.Boule;
import jeu.Boule.Couleurs;

import java.util.Scanner;


public class HumainPlaceur implements Placeur {

	@Override
	public void placer(Boule []tabBoule) {
		/*Le placeur Humain choisi ces boules tant qu'il n'a pas rempli tous les trous, et confirmer ses choix*/
		
		Scanner sc = new Scanner(System.in);
		int choixTrou, choixCoul, choix;
		boolean[] tabDesTrousRemplis = new boolean[tabBoule.length] ;
		for(int i = 0 ; i < tabBoule.length ; i++)
			tabDesTrousRemplis[i] = false;
		boolean rempli = false;
		boolean confirmation = false;
		
		while(!rempli || !confirmation){
			System.out.println("Placeur, choisissez les boules que vous voulez faire deviner..");
			int i = 1;
			while(i - 1 < tabBoule.length){
				System.out.println("Trou n°" + i + " : " + tabBoule[i - 1].toString());
				i++;
			}
			do{
			System.out.print("Quel trou voulez-vous modifier ?");
			choixTrou = sc.nextInt();
			}while(choixTrou < 1 || choixTrou > i);
			
			do{
			System.out.println("Quelle couleur voulez-vous mettre ?");
			System.out.println("(1 pour Rose, 2 pour Bleu, 3 pour Vert, 4 pour Jaune, 5 pour Violet, 6 pour Orange");
			System.out.println("Votre choix : ");
			choixCoul = sc.nextInt();
			}while(choixCoul < 1 || choixCoul > 6);
					
			tabBoule[choixTrou - 1]	= new Boule(Couleurs.values()[choixCoul -1]);	
			tabDesTrousRemplis[choixTrou - 1] = true;
			
			i = 1;
			rempli = true;
			while(i < tabDesTrousRemplis.length){
				if(!tabDesTrousRemplis[i]){
					rempli = false;
					break;
				}
				else
					i++;
			}
			
			if(rempli){
				do{
				System.out.println("Avez-vous fini ? (1 pour Oui, 2 pour Non)");
				choix = sc.nextInt();
				}while(choix < 1 || choix > 2);
				
				if(choix == 1)
					confirmation = true;
			}
		
		}
	}


}
