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

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village= new Village("Le village des Irréductibles",10,5);
		abraracourcix=new Chef ("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite= new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		assertEquals(village.trouverHabitant("nomVendeur"),vendeur);
	}

}
