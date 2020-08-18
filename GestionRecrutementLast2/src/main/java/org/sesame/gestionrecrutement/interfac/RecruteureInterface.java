package org.sesame.gestionrecrutement.interfac;

import org.sesame.gestionrecrutement.entities.Recruteure;

public interface RecruteureInterface {
	public Iterable<Recruteure> getAll();
	public Recruteure getId(Long id);
    public void Delete(Long id);
	public Iterable<Recruteure> getOffreByNom(String nom);
    public Recruteure add(Recruteure r);
    public Recruteure update(Recruteure r);
}
