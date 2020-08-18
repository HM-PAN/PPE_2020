package org.sesame.gestionrecrutement.servic;

import org.sesame.gestionrecrutement.Repository.CvRepository;
import org.sesame.gestionrecrutement.entities.Cv;
import org.sesame.gestionrecrutement.interfac.CvInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvService implements CvInterface {
	@Autowired
	private CvRepository r;

	@Override
	public Iterable<Cv> getAll() {
		// TODO Auto-generated method stub
		return r.findAll();
	}

	@Override
	public Cv getId(Long id) {
		// TODO Auto-generated method stub
		return r.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		r.deleteById(id);
	}

	@Override
	public Cv add(Cv c) {
		// TODO Auto-generated method stub
		return r.save(c);
	}

}
