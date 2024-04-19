package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public String getNom() {
		return nom;
	}

	public int getEffetPotion() {
		return effetPotion;
	}

	/*
	 * public String prendreParole() { return "Le gaulois " + nom + " : "; }
	 */

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/*
	 * public void frapper(Romain romain) { System.out.println(nom +
	 * " envoie un grand coup dans la mâchoire de " + romain.getNom());
	 * romain.recevoirCoup((force / 3) * effetPotion); }
	 */

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain romain = new Romain("Romain", 4);

		asterix.parler("Je suis le plus fort gaulois ici ");
		asterix.boirePotion(2);
		asterix.frapper(romain);

	}

}
