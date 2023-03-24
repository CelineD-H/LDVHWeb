package fr.cdh.ldvh.bo;

public abstract class Creature {

	String nom;
	String description;
	
	public Creature() {
	}
	
	public Creature(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}
	
	public String getName() {
		return this.nom;
	}

	@Override
	public String toString() {
		
		return this.description;
	}
}
