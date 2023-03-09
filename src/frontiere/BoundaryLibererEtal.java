package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui!\n");
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe=donneesEtal[0];
			if (etalOccupe.equals("true")) {
				System.out.println("Vous avez vendu "+donneesEtal[4]+" sur "+donneesEtal[3]+" "+donneesEtal[2]+".\n");
				System.out.println("Au revoir "+nomVendeur+", passez une bonne journée.\n");
			}
		}
	}
}
