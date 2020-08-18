package org.sesame.gestionrecrutement.Repository;




import org.sesame.gestionrecrutement.entities.Candidat;
import org.sesame.gestionrecrutement.entities.Offre;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffrereRepository extends ElasticsearchRepository<Offre, Long>{
	   Iterable<Offre> findByTitreContaining(String nome);
	   Iterable<Offre> findByTitre(String nom);
	  
}
