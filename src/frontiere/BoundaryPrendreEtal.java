package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un etal.");
			if(controlPrendreEtal.resteEtals()){
				System.out.println("C'est parfait il me reste un �tal pour vous!");
				installerVendeur(nomVendeur);
			}else {
				System.out.println("D�sol� "+nomVendeur+" je n'ai plus d'�tal qui ne soit pas d�j� occup�");
			}
		}else {
			System.out.println("Je suis d�sol� "+nomVendeur+" mais je ne peux vous aider.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("Il me faudrait quelques renseignements :");
		System.out.println("Quel produit souhaitez-vous vendre?");
		String produit=scan.nextLine();
		int nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est install� � l'�tal n� "+numeroEtal);
		}
	}
}
