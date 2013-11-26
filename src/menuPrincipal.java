import java.util.*;


public class menuPrincipal{

	public static void main(String[] args) {
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		while (menu != 0){
			System.out.println("MENU MASTERMIND\n\n1. Jouer au Master Mind\n2. Options\nChoix : ");
			menu = Integer.parseInt(sc.nextLine());
			while(menu < 1 || menu > 2){
				
			}
		}
		

	}

}
