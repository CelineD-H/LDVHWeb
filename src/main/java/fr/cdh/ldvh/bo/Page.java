package fr.cdh.ldvh.bo;

import java.util.ArrayList;
import java.util.List;

public class Page {
	
	private int numPage;
	private String texte;
	List<Page> destinations = new ArrayList<>();
	List<Objet> objetsPage = new ArrayList<>();
	List<Creature> creaturesPage = new ArrayList<>();
	boolean finHistoire;
	Aventurier heros;
	
	public Page() {
	}
	
	public Page(int numero, String texte) {
		this.numPage = numero;
		this.texte = texte;
	}
	public Page(int numero, String texte, boolean fin) {
		this.numPage = numero;
		this.texte = texte;
		this.finHistoire = fin;
	}
	
	public void ajouterFin(boolean gagne) {
		this.finHistoire = gagne;
	}
	
	public void ajouterDestination(Page page) {
		this.destinations.add(page);
	}
	
	public void ajouterCreature(Creature c) {
		this.creaturesPage.add(c);
	}
	
	public void ajouterObjet(Objet o) {
		this.objetsPage.add(o);
	}
	
	public void ajouterAventurier(Aventurier joueur) {
		this.heros = joueur;
	}
	
	public Aventurier getAventurier() {
		return this.heros;
	}
	
	public int getNumPage() {
		return this.numPage;
	}
	

	public List<Page> getDestinations() {
		return this.destinations;
	}
	
	public List<Creature> getCreatures() {
		return this.creaturesPage;
	}
	
	public List<Objet> getObjets() {
		return this.objetsPage;
	}

	public String getTexte() {
		return this.texte;
	}

	public boolean isFinHistoire() {
		return finHistoire;
	}

	@Override
	public String toString() {
		String nom = "Page" + numPage;
		return nom;
	}
}
