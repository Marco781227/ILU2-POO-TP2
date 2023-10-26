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
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol�e " + nomVendeur
					+ " mais il faut �tre un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un �tal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol�e " + nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�j� occup�.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder dialogue = new StringBuilder();
		dialogue.append("C'est parfait, il me reste un �tal pour vous !\n");
		dialogue.append("Il me faudrait quelques renseignements : \n");
		dialogue.append("Quel produit souhaitez-vous vendre ?\n");
		System.out.println(dialogue);
		String produit = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != 1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n� " + numeroEtal+1 + "\n");
		}
	}
}
