package org.sesame.gestionrecrutement.controller;



import org.sesame.gestionrecrutement.entities.Candidat;
import org.sesame.gestionrecrutement.interfac.CandidatInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/candidat")
public class CandidatController {
	@Autowired
	private CandidatInterface candidatrepository;
	
	@PostMapping("/add")
	Candidat ajoutcandidat(@RequestBody Candidat c) {
		if(c !=null) {
			return candidatrepository.add(c);
			
		}
		return null;
		
	}
	
	  @GetMapping ("/get")
	  Iterable<Candidat> getAll(){ 
		  return   candidatrepository.getAll();
	  
	  }
	  
	  @DeleteMapping("/delet/{idC}")
	  void deletcondidat(@PathVariable Long idC) {
		  candidatrepository.Delete(idC);
	  }
	  @GetMapping("/getc/{id}")
		Candidat getcandidat(@PathVariable  Long id) {	
		
			  return candidatrepository.getId(id);
		 
		
		}
	  @GetMapping("/getByNom/{nom}")
	  Iterable<Candidat> getcandidat(@PathVariable  String nom) {
			
		return candidatrepository.getCandidatByNom(nom);
		}

}
