package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois habitant;
	
	@BeforeEach
	public void init() {
		village = new Village ("Le village",20,10);
		abraracourcix= new Chef("abraracourcix",10,village);
		habitant = new Gaulois("Asterix", 4);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerif = new ControlVerifierIdentite(village);
		assertNotNull(controlVerif,"Le constructeur renvoit NULL");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerif = new ControlVerifierIdentite(village);
		village.ajouterHabitant(habitant);
		assertTrue(controlVerif.verifierIdentite("Asterix"));
		assertFalse(controlVerif.verifierIdentite("Idefix"));
	}

}
