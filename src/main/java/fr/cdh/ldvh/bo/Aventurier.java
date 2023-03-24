package fr.cdh.ldvh.bo;

import java.util.ArrayList;
import java.util.List;

public class Aventurier {

	private String nom;
	private int pdV;
	private int pAtt;
	private int pDef;
	private List<Objet> besace = new ArrayList<>();
	private int or;

	public Aventurier() {
	}

	public Aventurier(String nom, int pdV, int pA, int pD) {
		this.nom = nom;
		this.pdV = pdV;
		this.pAtt = pA;
		this.pDef = pD;
	}
	
	public Aventurier(String nom) {
		this.setNom(nom);
		this.setpAtt(5);
		this.setpDef(3);
		this.setPdV(50);
		this.setOr(5);
	}

	public int getPdV() {
		return pdV;
	}

	public void setPdV(int pdV) {
		this.pdV = pdV;
	}

	public int getpAtt() {
		return pAtt;
	}

	public void setpAtt(int pAtt) {
		this.pAtt = pAtt;
	}

	public int getpDef() {
		return pDef;
	}

	public void setpDef(int pDef) {
		this.pDef = pDef;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setOr(int or) {
		this.or = or;
	}

	
	public String getBesaceToString() {
		String besace = "Besace : ";
		for (Objet o : this.besace) {
			if (o instanceof Tresor) {
				// on ne veut pas l'afficher, il est déjà dans or
			} else {
			besace = besace.concat(String.format("%s, ", o.toString()));
			}
		}
		return besace;
	}
	
	public List<Objet> getBesace() {
		return this.besace;
	}
	
	public String getOr() {
		String or = String.format("Or : %d", this.or);
		return or;
	}
	
	public void ajouterObjet(Objet objet) {
		besace.add(objet);
		if (objet instanceof Attaque) {
			this.pAtt += ((Attaque) objet).getpAtt();
		}
		else if (objet instanceof Defense) {
			this.pDef += ((Defense) objet).getDef();
		}
		else if (objet instanceof Medecine) {
			this.pdV += ((Medecine) objet).getPDV();
		}
		else if (objet instanceof Tresor) {
			this.or += ((Tresor) objet).getValeur();
		}
	}
	@Override
	public String toString() {
		return this.nom;
	}

}
