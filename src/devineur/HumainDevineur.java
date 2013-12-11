package devineur;

import java.util.Scanner;

import jeu.TableauBoule;
import jeu.Boule.Couleurs;

public class HumainDevineur implements Devineur
{

	@SuppressWarnings("resource")
	@Override
	public void proposer(TableauBoule oldProposition)
	{
		Scanner sc = new Scanner(System.in);
		int choixTrou, choixCoul, choix;
		boolean[] tabDesTrousRemplis = new boolean[oldProposition.tab.size()];
		for (int i = 0; i < oldProposition.tab.size(); i++)
			tabDesTrousRemplis[i] = false;
		boolean rempli = false;
		boolean confirmation = false;

		while (!rempli || !confirmation) {
			System.out.println("Devineur, choisissez les boules qui composeront votre combinaison..");
			int i = 1;
			while (i - 1 < oldProposition.tab.size()) {
				System.out.println("Trou n°" + i + " : " + oldProposition.tab.get(i - 1).toString());
				i++;
			}
			do {
				System.out.print("Quel trou voulez-vous modifier ? (saisissez 0 pour ne rien changer)\n");
				choixTrou = sc.nextInt();
			} while (choixTrou < 0 || choixTrou > i);
			if (choixTrou == 0) {
				rempli = true;
			}
			else {
				do {
					System.out.println("Quelle couleur voulez-vous mettre ?");
					System.out.println("(1 pour Rose, 2 pour Bleu, 3 pour Vert, 4 pour Jaune, 5 pour Violet, 6 pour Orange");
					System.out.println("Votre choix : ");
					choixCoul = sc.nextInt();
				} while (choixCoul < 1 || choixCoul > 6);

				oldProposition.tab.get(choixTrou - 1).setCouleur(Couleurs.values()[choixCoul - 1]);
				tabDesTrousRemplis[choixTrou - 1] = true;

				i = 1;
				rempli = true;
				while (i < tabDesTrousRemplis.length) {
					if (!tabDesTrousRemplis[i]) {
						rempli = false;
						break;
					}
					else
						i++;
				}
			}
			if (rempli) {
				do {
					System.out.println("Avez-vous fini ? (1 pour Oui, 2 pour Non)");
					choix = sc.nextInt();
				} while (choix < 1 || choix > 2);

				if (choix == 1) confirmation = true;
			}

		}
	}

	@Override
	public void lirePions(TableauBoule tabBoule, int nbPionBlanc, int nbPionRouge)
	{
		// TODO Auto-generated method stub
	}

}
