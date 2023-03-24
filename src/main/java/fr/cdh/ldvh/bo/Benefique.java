package fr.cdh.ldvh.bo;

public class Benefique extends Creature {

	private String enigme;
	
	public Benefique() {
	}
	
	public Benefique(String nom, String description, String enigme) {
		super(nom, description);
		this.enigme = enigme;
	}

	public String getEnigme() {
		return this.enigme;
	}
	
	
}

