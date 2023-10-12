package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder dialogueForceV = new StringBuilder();
					dialogueForceV.append("Bienvenue villageois " + nomVisiteur + "\n");
					dialogueForceV.append("Quel est votre force ?\n");
					int forceVillageois = Clavier.entrerEntier(dialogueForceV.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceVillageois);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder dialogueForceD = new StringBuilder();
		dialogueForceD.append("Bienvenue druide " + nomVisiteur + "\n");
		dialogueForceD.append("Quel est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(dialogueForceD.toString());
		int effetPotionMin;
		int effetPotionMax;

		do {
			effetPotionMin = Clavier
					.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?\n");
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum\n");
			}
		} while (effetPotionMax < effetPotionMin);

		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
