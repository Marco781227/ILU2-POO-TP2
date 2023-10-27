package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix,obelix;
	private ControlVerifierIdentite controlVerif;
	
	@BeforeEach
	public void init() {
		village = new Village ("Le village",20,1);
		abraracourcix= new Chef("abraracourcix",10,village);
		asterix = new Gaulois("Asterix", 4);
		obelix = new Gaulois("Obelix",17);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerif, village);
		assertNotNull(controlPrendre,"Le constructeur renvoit NULL");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerif, village);
		assertTrue(controlPrendre.resteEtals());
		village.installerVendeur(asterix, "produit", 5);
		assertFalse(controlPrendre.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerif, village);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		assertNotEquals(-1,controlPrendre.prendreEtal("Asterix", "produit1", 10));
		assertEquals(-1,controlPrendre.prendreEtal("Obelix", "produit2", 10));

	}
	
	@Test
	void testVerifierIdentite() {
		
	}

}
