package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void init() {
		village = new Village ("Le village",20,10);
		abraracourcix= new Chef("abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Controlleur ne renvoi pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 4);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Ugo"));
		controlEmmenager.ajouterDruide("Panoramix", 4, 2, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));

	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 4, 2, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 4);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
	}

}
