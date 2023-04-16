package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village= new Village("Le village des Irréductibles",10,5);
		abraracourcix=new Chef ("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		String[] expected = {"Abraracourcix"};
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(),expected);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomVillage(),"Le village des Irréductibles");
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(),5);
	}

}
