package test;

import jeu.TableauBoule;
import junit.framework.TestCase;
import devineur.OrdiDevineur;

public class OrdiDevineurTest extends TestCase
{
	
	OrdiDevineur ordi = new OrdiDevineur(4);
	TableauBoule tab = new TableauBoule(4);
	
	public void testLirePions() throws Exception{
		assertFalse(ordi.lirePions(tab,2, 4));
		ordi.proposer(tab);
	}

}
