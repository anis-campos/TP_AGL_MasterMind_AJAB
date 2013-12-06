package jeu;

import java.util.ArrayList;
import java.util.List;


public class TableauBoule {
	public List<Boule> tab;
	
	public TableauBoule( int nbBoule)
	{
		tab=new ArrayList<Boule>(nbBoule);
		for (int i=0; i<nbBoule;i++){
			tab.add(new Boule());
		}
	}
}
