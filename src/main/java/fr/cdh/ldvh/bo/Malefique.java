package fr.cdh.ldvh.bo;

public class Malefique extends Creature {

	private int pdV;
	private int pAtt;
	private int pDef;
	
	public Malefique() {
	}
	
	public Malefique(String nom, String description, int pdV, int pA, int pD) {
		super(nom, description);
		this.pdV = pdV;
		this.pAtt = pA;
		this.pDef = pD;
	}

	public int getPdV() {
		return this.pdV;
	}

	public int getpAtt() {
		return this.pAtt;
	}

	public int getpDef() {
		return this.pDef;
	}
	
	
	
}
