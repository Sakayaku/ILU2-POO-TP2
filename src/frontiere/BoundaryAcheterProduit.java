package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous acheter?\n");
			String produit=scan.nextLine();
			if (controlAcheterProduit.produitExistant(produit)) {
				System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+"?\n");
				controlAcheterProduit.commercantVendantProduit(produit);
				int commercant=Clavier.entrerEntier(null);
				String nomCommercant=controlAcheterProduit.choisirCommercant(commercant-1, produit);
				if (nomCommercant!=null) {
					System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+nomCommercant);
					System.out.println("Bonjour "+nomAcheteur+"\n");
					int quantiteVoulue=Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter?\n");
					System.out.println(nomAcheteur+" a acheté "+controlAcheterProduit.acheter(nomCommercant, quantiteVoulue)+" "+produit+" à "+nomCommercant);
				}else {
					System.out.println("Ce commercant n'existe pas!\n");
				}
			}else {
				System.out.println("Personne ne vend ce produit!");
			}
		}else {
			System.out.println("Seul un habitant du village peut vendre ou acheter au marché");
		}
	}
}
