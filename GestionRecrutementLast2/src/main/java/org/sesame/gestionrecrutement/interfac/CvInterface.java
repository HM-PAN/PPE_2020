package org.sesame.gestionrecrutement.interfac;

import org.sesame.gestionrecrutement.entities.Cv;

public interface CvInterface {
	public Iterable<Cv> getAll();
	public Cv getId(Long id);
    public void Delete(Long id);
    public Cv add(Cv c);

}
