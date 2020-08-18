package org.sesame.gestionrecrutement.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "gestionrecrutement", type = "Offres",shards=2)

public class Offre {
	@Id
	private Long num_offre;
	private String titre;
	private String domaine;
	private String nom_entreprise;
	private Date date_Lancement;
	private Date date_Limite;
	public Offre(Long num_offre, String titre, String domaine, String nom_entreprise, Date date_Lancement,
			Date date_Limite, int capacite) {
		super();
		this.num_offre = num_offre;
		this.titre = titre;
		this.domaine = domaine;
		this.nom_entreprise = nom_entreprise;
		this.date_Lancement = date_Lancement;
		this.date_Limite = date_Limite;
		this.capacite = capacite;
	}
	public Long getNum_offre() {
		return num_offre;
	}
	public void setNum_offre(Long num_offre) {
		this.num_offre = num_offre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	public Date getDate_Lancement() {
		return date_Lancement;
	}
	public void setDate_Lancement(Date date_Lancement) {
		this.date_Lancement = date_Lancement;
	}
	public Date getDate_Limite() {
		return date_Limite;
	}
	public void setDate_Limite(Date date_Limite) {
		this.date_Limite = date_Limite;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public List<Candidat> getCandidat() {
		return candidat;
	}
	public void setCandidat(List<Candidat> candidat) {
		this.candidat = candidat;
	}
	private int capacite;
	private List<Candidat> candidat = new ArrayList<>();
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
