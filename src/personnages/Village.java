package personnages;

public class Village {
	private String nom;
	private Chef chef;
	int nbVillageois = 0;
	Gaulois villageois[];
	
	
	public Village(String nom, nbVillageoisMaximum) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant() {
		
	}
	
	
}
