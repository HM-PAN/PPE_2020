package org.sesame.gestionrecrutement.servic;

import org.sesame.gestionrecrutement.Repository.RecruteureRepository;
import org.sesame.gestionrecrutement.entities.Recruteure;
import org.sesame.gestionrecrutement.interfac.RecruteureInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruteureService implements RecruteureInterface{
	@Autowired
	private RecruteureRepository re;

	@Override
	public Iterable<Recruteure> getAll() {
		// TODO Auto-generated method stub
		return re.findAll();
	}

	@Override
	public Recruteure getId(Long id) {
		// TODO Auto-generated method stub
		return re.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
      re.deleteById(id);		
	}

	@Override
	public Iterable<Recruteure> getOffreByNom(String nom) {
		if(nom!= null) {
			return re.findByNom(nom);
		}else return null;
	}

	@Override
	public Recruteure add(Recruteure r) {
		// TODO Auto-generated method stub
		return re.save(r);
	}
	
	@Override
	public Recruteure update(Recruteure r) {
		return re.save(r);
	}

}
