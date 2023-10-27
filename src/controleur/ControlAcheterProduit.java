package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

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

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] trouverVendeursProduit(String produit) {
		Gaulois[] vendeurs=village.rechercherVendeursProduit(produit);
		String[] nomVendeurs= new String[vendeurs.length];
		for (int i=0;i<vendeurs.length;i++) {
			nomVendeurs[i]=vendeurs[i].getNom();
		}
		return nomVendeurs;
	}
	public int acheterProduit(String nomVendeur,int quantiteAcheter) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteVendu = etal.acheterProduit(quantiteAcheter);
		return quantiteVendu;
	}
	
}	
