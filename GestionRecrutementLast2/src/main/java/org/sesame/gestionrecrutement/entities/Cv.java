package org.sesame.gestionrecrutement.entities;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@Document(indexName = "gestionrecrutement", type = "CV",shards=2)

public class Cv {
	@Id 
	private Long num_cv;
	private String contenue;
	private Candidat candidat;
	public Candidat getCandidat() {
		return candidat;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	public Cv(Long num_cv, String contenue) {
		super();
		this.num_cv = num_cv;
		this.contenue = contenue;
	}
	public Cv() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNum_cv() {
		return num_cv;
	}
	public void setNum_cv(Long num_cv) {
		this.num_cv = num_cv;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

}
