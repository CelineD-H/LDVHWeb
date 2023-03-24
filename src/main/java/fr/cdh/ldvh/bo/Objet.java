package fr.cdh.ldvh.bo;

public abstract class Objet {

	private int id;
	private String nom;
	private String description;

	public Objet() {
	}

	public Objet(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}
	
	
	public int getId() {
		return this.id;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

}
