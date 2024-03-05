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

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	private void assertForce() {
		assert force > 0 : "la force d’un Romain est toujours positive" ;
	}
	
	public static void main(String[] args) {
		
		
		Romain minus = new Romain("Minus", 6);
		minus.assertForce();
		minus.prendreParole();
		minus.parler("Je suis le plus fort romain ici ");
		minus.recevoirCoup(5);
	}
}
