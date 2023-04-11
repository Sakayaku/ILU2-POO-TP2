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

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village= new Village("Le village des Irréductibles",10,5);
		abraracourcix=new Chef ("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		assertEquals(controlPrendreEtal.prendreEtal("nomVendeur", "Fleurs", 5),1);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		assertTrue(controlVerifierIdentite.verifierIdentite("nomVendeur"));
	}

}
