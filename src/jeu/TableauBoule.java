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
	
	public String toString (){
		String chaine="[";
		for (Boule boule : tab)
			chaine+=" "+boule.toString()+" ,";
		chaine = chaine.substring(0, chaine.length()-2) +" ]"; //enlever la virgule en trop
		return chaine;
	}
	
//	public static void main (String[] args){
//		TableauBoule tab = new TableauBoule(4);
//		System.out.println(tab.tab.size());
//		for (Boule boule : tab.tab)
//			System.out.print(boule+" ");
//	}
}
