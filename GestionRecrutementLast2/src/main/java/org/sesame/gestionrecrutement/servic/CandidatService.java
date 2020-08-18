package org.sesame.gestionrecrutement.servic;



import org.sesame.gestionrecrutement.Repository.CandidatRepository;
import org.sesame.gestionrecrutement.entities.Candidat;
import org.sesame.gestionrecrutement.interfac.CandidatInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService implements CandidatInterface{
	@Autowired
	private CandidatRepository repository;

	@Override
	public Iterable<Candidat> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Candidat getId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	

	@Override
	public Candidat add(Candidat c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public Iterable<Candidat> getCandidatByNom(String nom) {
		// TODO Auto-generated method stub
		return  (Iterable<Candidat>) repository.findByNomContaining(nom);
	}

	

}
