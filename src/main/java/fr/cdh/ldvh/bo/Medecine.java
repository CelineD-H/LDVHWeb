package fr.cdh.ldvh.bo;

public class Medecine extends Objet {

	private int pdV;
	
	public Medecine() {
	}
	
	public Medecine(String nom, String description, int pdV) {
		super(nom, description);
		this.pdV = pdV;
	}
	
	public int getPDV() {
		return this.pdV;
	}
	
	@Override
	public String toString() {
		return this.getNom();
	}
}
