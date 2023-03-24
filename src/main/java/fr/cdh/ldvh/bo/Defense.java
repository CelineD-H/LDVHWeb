package fr.cdh.ldvh.bo;

public class Defense extends Objet {

	private int pDef;
	
	public Defense() {
	}

	public Defense(String nom, String description, int pDef) {
		super(nom, description);
		this.pDef = pDef;
	}
	
	public int getDef() {
		return this.pDef;
	}
	
}
