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

	/*
	 * public void recevoirCoup(int forceCoup) { 
	 * assert force > 0 : "la force d’un Romain est toujours positive"; 
	 * int forceInitial = force; 
	 * force-= forceCoup;
	 * assert force < forceInitial : "la force doit etre diminué après recevoir un coup.";
	 * 
	 * if (force > 0) { 
	 * 	parler("Aïe");
	 *  } else {
	 *   parler("J'abandonne..."); } }
	 */

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		/*
        if (force>0) {
        	parler("Aie");
        } else {
        	equipementEject = ejecterEquipement();
        	parler("J'abandonne");
        }
		 */

		if (force==0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte = "\nMais heureusement, grace à mon équipement sa force est diminué de " +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
		System.out.println(minus.nbEquipement);
		minus.sEquiper(Equipement.CASQUE);
		System.out.println(minus.nbEquipement);
		minus.sEquiper(Equipement.BOUCLIER);
		System.out.println(minus.nbEquipement);
		minus.sEquiper(Equipement.CASQUE);

	}
}
