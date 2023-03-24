package fr.cdh.ldvh.bo;

public class Attaque extends Objet {

	private int pAtt;
	
	public Attaque() {
	}

	public Attaque(String nom, String description, int pA) {
		super(nom, description);
		this.pAtt = pA;
	}

	public int getpAtt() {
		return this.pAtt;
	}
	
	@Override
	public String toString() {
		return this.getNom();
	}
	
}
