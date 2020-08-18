package org.sesame.gestionrecrutement.interfac;


import org.sesame.gestionrecrutement.entities.Candidat;

public interface CandidatInterface {
	public Iterable<Candidat> getAll();
	public Candidat getId(Long id);
    public void Delete(Long id);
	public Iterable<Candidat> getCandidatByNom(String nom);
    public Candidat add(Candidat c);
    

}
