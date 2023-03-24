package fr.cdh.ldvh.bo;

public class Tresor extends Objet {

	private int prix;
	
	public Tresor() {
	}
	
	public Tresor(String nom, String description, int prix) {
		super(nom, description);
		this.prix = prix;
	}
	
	public int getValeur() {
		return this.prix;
	}
}
