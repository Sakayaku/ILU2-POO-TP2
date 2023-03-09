package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		int i=0;
		String[] infoMarche=controlAfficherMarche.donnerInfosMarche();
		if (infoMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard!");
		}else {
			System.out.println(nomAcheteur+", vous trouverez au marché :");
			while (i<infoMarche.length) {
				String vendeur=infoMarche[i];
				i++;
				String quantite=infoMarche[i];
				i++;
				String produit=infoMarche[i];
				i++;				
				System.out.println("-"+vendeur+" qui vend "+quantite+" "+produit);
			}
		}
	}
}
