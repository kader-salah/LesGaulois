package personnages;

public class Romain {

	private String nom;
	private int force;

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
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public static void main(String[] args) {

		Romain dz = new Romain("DZ", 4);
		dz.prendreParole();
		dz.parler("Je suis le plus fort romain ici ");
		dz.recevoirCoup(5);
	}
}
