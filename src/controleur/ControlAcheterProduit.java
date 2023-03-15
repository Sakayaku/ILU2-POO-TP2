package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	public boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	public boolean produitExistant(String produit) {
		return village.rechercherVendeursProduit(produit)!=null;
	}
	public void commercantVendantProduit(String produit) {
		int nombreCommercants=village.rechercherVendeursProduit(produit).length;
		for (int i=0;i<nombreCommercants;i++) {
			System.out.println((i+1)+" - "+village.rechercherVendeursProduit(produit)[i].getNom());
		}
	}
	public String choisirCommercant(int numeroCommercant, String produit) {
		if (numeroCommercant<village.rechercherVendeursProduit(produit).length && (village.rechercherVendeursProduit(produit)[numeroCommercant]!=null)) {
				 return village.rechercherVendeursProduit(produit)[numeroCommercant].getNom();
		}
		return null;
	}
	public int acheter(String vendeur, int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur).acheterProduit(quantite);
	}
}
