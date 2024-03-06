package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0 : "la force d’un Romain est toujours positive";
		int forceInitial = force;
		force -= forceCoup;
		assert force < forceInitial : "la force doit etre diminué après recevoir un coup.";

		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public void sEquiper(Equipement equipement) {
		
		switch (nbEquipement) {

		case 2:
			printPossedeTousEquipements();
			break;

		case 1:
			if (equipements[0] == equipement) {
				printPossedeEquipement(equipement);
			} else {
				equipements[1] = equipement;
				nbEquipement++;
				printsEquipeAvecEquipement(equipement);
			}
			break;

		case 0:
			equipements[0] = equipement;
			nbEquipement++;
			printsEquipeAvecEquipement(equipement);
			break;

		default:
			printErreur();

		}
	}

	private void printErreur() {
		System.out.println("Réessayez S'il vous plait");
	}

	private void printsEquipeAvecEquipement(Equipement equipement) {
		System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement + " !");
	}

	private void printPossedeEquipement(Equipement equipement) {
		System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement + " !");
	}

	private void printPossedeTousEquipements() {
		System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	private void assertForce() {
		assert force > 0 : "la force d’un Romain est toujours positive";
	}

	public static void main(String[] args) {

		Romain minus = new Romain("Minus", 6);
		minus.assertForce();
		minus.prendreParole();
		minus.parler("Je suis le plus fort romain ici ");
		minus.recevoirCoup(5);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

		


	}
}
