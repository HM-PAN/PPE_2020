package org.sesame.gestionrecrutement.Repository;

import org.sesame.gestionrecrutement.entities.Recruteure;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruteureRepository  extends ElasticsearchRepository<Recruteure, Long>{
	Iterable<Recruteure> findByNom(String nom);

}
