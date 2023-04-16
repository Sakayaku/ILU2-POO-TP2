package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village= new Village("Le village des Irr�ductibles",10,5);
		abraracourcix=new Chef ("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAcheterProduit() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		assertTrue(controlAcheterProduit.isHabitant("nomVendeur"));
	}

	@Test
	void testProduitExistant() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		controlAcheterProduit.produitExistant("Autre chose");
		assertNotNull(controlAcheterProduit.produitExistant("Fleurs"));
	}

	@Test
	void testCommercantVendantProduit() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		controlAcheterProduit.commercantVendantProduit("Fleurs");
	}

	@Test
	void testChoisirCommercant() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		controlAcheterProduit.choisirCommercant(0, "Fleurs");
	}

	@Test
	void testAcheter() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		controlAcheterProduit.acheter("nomVendeur", 5);
	}

}
