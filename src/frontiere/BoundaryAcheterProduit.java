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
		System.out.println("Quel produit souhaitez-vous acheter ?");
		String produit = scan.nextLine();
		String[] nomVendeurs=controlAcheterProduit.trouverVendeursProduit(produit);
		if (nomVendeurs.length==0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.\n");
			return;
		}
		else {
			StringBuilder dialogChoix = new StringBuilder("Chez quel commerçant voulez-vous acheter des fleurs?\n");
			for (int i=0;i<nomVendeurs.length;i++) {
				dialogChoix.append(i+1 + " - " + nomVendeurs[i] + "\n");
			}
			int choix = Clavier.entrerEntier(dialogChoix.toString());
			choix--;
			while(choix<0 && choix>=nomVendeurs.length){
				System.out.println("Veuillez entrer un chiffre valide.\n");
				choix = Clavier.entrerEntier(dialogChoix.toString());
				choix--;
			}
			String vendeur = nomVendeurs[choix];
			StringBuilder dialogAchat = new StringBuilder(nomAcheteur + " se déplace jusqu'à l'étal du vendeur "+vendeur+"\n");
			dialogAchat.append("Combien de "+ produit+ " voulez-vous acheter?\n");
			int quantiteAcheter = Clavier.entrerEntier(dialogAchat.toString());
			int quantiteVendu = controlAcheterProduit.acheterProduit(vendeur, quantiteAcheter);
			if (quantiteVendu==0) {
				System.out.println(nomAcheteur+" veut acheter "+quantiteAcheter+" "+produit+", malheureusement il n'y en a plus!\n");
			}
			else if (quantiteVendu<quantiteAcheter) {
				System.out.println(nomAcheteur+" veut acheter 5 fleurs, malheureusement "+vendeur+" n'en a plus que "+quantiteVendu
						+". "+nomAcheteur+" achète tout le stock de Bonemine.\n");
			}
			else {
				System.out.println(nomAcheteur+" achète "+quantiteVendu+" "+produit+ " à "+vendeur+".\n");
			}
		}
	}
}
