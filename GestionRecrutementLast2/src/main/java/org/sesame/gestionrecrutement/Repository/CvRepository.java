package org.sesame.gestionrecrutement.Repository;

import org.sesame.gestionrecrutement.entities.Cv;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends ElasticsearchRepository<Cv, Long>{

}
