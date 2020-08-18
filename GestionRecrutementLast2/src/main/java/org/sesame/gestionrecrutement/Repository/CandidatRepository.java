package org.sesame.gestionrecrutement.Repository;

import java.util.Iterator;

import org.sesame.gestionrecrutement.entities.Candidat;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository  extends ElasticsearchRepository<Candidat, Long>{
	Iterable<Candidat> findByNomContaining(String nom);
	Candidat  findByNom(String nom);

}
