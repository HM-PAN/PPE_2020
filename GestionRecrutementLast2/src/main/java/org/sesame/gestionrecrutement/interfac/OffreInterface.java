package org.sesame.gestionrecrutement.interfac;


import org.sesame.gestionrecrutement.entities.Offre;

public interface OffreInterface {
	
	public Iterable<Offre> getAll();
	public Offre getId(Long id);
    public void Delete(Long id);
	public Iterable<Offre> getOffreByNom(String nom);
    public Offre add(Offre c);
    public Iterable<Offre> getOffreContaining(String str);
    public Offre Update( Long id,Offre c);
    public Offre Update1( Offre c , Long n);


}
