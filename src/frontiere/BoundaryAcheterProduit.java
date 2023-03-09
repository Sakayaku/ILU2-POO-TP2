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
		// TODO Ã  completer
		if (controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous achter?");
			String produit=scan.nextLine();
			controlAcheterProduit.acheter(produit);
		}else {
			System.out.println("Seul un habitant du village peut vendre ou acheter au marché");
		}
	}
}
