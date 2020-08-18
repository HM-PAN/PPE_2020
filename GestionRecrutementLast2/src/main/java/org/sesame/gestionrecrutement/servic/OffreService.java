package org.sesame.gestionrecrutement.servic;


import java.util.ArrayList;
import java.util.List;

import org.sesame.gestionrecrutement.Repository.CandidatRepository;
import org.sesame.gestionrecrutement.Repository.OffrereRepository;
import org.sesame.gestionrecrutement.entities.Candidat;
import org.sesame.gestionrecrutement.entities.Offre;
import org.sesame.gestionrecrutement.interfac.OffreInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class OffreService implements OffreInterface {

	@Autowired
	private OffrereRepository re;
	@Autowired
	private CandidatRepository ce;
	@Override
	public Iterable<Offre> getAll() {
		// TODO Auto-generated method stub
		return re.findAll();
	}

	@Override
	public Offre getId(Long id) {
		// TODO Auto-generated method stub
		return re.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		re.deleteById(id);
		
	}

	@Override
	public Iterable<Offre> getOffreByNom(String nom) {
		return (Iterable<Offre>) re.findByTitre(nom);
	}

	@Override
	public Offre add(Offre c) {
		// TODO Auto-generated method stub
		return re.save(c);
	}

	@Override
	public Iterable<Offre> getOffreContaining(String str) {
		// TODO Auto-generated method stub
		return re.findByTitreContaining(str);
		
	}

	@Override
	public Offre Update(Long id,Offre c) {
       //Long id = re.index(c).getNum_offre();
       Offre o = re.findById(id).get();
       o.setTitre(c.getTitre());
       o.setNom_entreprise(c.getNom_entreprise());
       o.setDate_Lancement(c.getDate_Lancement());
       o.setDate_Limite(c.getDate_Limite());
       List<Candidat> d = new ArrayList<Candidat>();
	   d.add(ce.findByNom("faka"));
	   o.setCandidat(d);
		return re.save(o);
	}

	@Override
	public Offre Update1(Offre c, Long n) {
		    Offre o = re.findById(c.getNum_offre()).get();
	       /*o.setNom(c.getNom());
	       o.setNom_entreprise(c.getNom_entreprise());
	       o.setDate_Lancement(c.getDate_Lancement());
	       o.setDate_Limite(c.getDate_Limite());*/
	       List<Candidat> d = o.getCandidat();
		   d.add(ce.findById(n).get());
		   o.setCandidat(d);
		   return re.save(o);
	}

	/*@Override
	public List<Candidat> addCandidatToOffre(String n, String ne) {
		         Candidat d =  ce.findByNom(n);
				 Offre e = re.findByNom(ne);
			     List <Candidat> l =e.getCandidat();
			     l.add(d);
			     return l;
			   
	}*/
	

	

}
