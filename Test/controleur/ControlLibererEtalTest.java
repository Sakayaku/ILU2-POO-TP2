package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal= new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal= new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		controlLibererEtal.isVendeur("Pas un vendeur");
		assertNotNull(controlLibererEtal.isVendeur("nomVendeur"));
	}

	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal= new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois vendeur = new Gaulois("nomVendeur", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "Fleurs", 10);
		String[] donneesEtalExpected = {"true","nomVendeur","Fleurs","10","0"};
		assertArrayEquals(controlLibererEtal.libererEtal("nomVendeur"),donneesEtalExpected);
	}

}
