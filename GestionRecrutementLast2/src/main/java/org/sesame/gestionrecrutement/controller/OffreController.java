package org.sesame.gestionrecrutement.controller;




import java.util.List;

import org.sesame.gestionrecrutement.Repository.CandidatRepository;
import org.sesame.gestionrecrutement.entities.Offre;
import org.sesame.gestionrecrutement.entities.Recruteure;
import org.sesame.gestionrecrutement.interfac.OffreInterface;
import org.sesame.gestionrecrutement.interfac.RecruteureInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/offre")
public class OffreController {
	@Autowired
	private OffreInterface or;
	@Autowired
	private RecruteureInterface r;
	@Autowired
	private CandidatRepository k;
	@PostMapping("/add")
	Offre  ajoutoffre(@RequestBody Offre offre) {
		if(offre !=null) {
			
			
			
			return or.add(offre);
		}
		return null;
		
	}
	@GetMapping ("/get")
	Iterable<Offre> getAll(){
		return or.getAll();
		
	}
	 @DeleteMapping("/delet/{idC}/{idR}")
	  void deletoffre(@PathVariable Long idC, @PathVariable Long idR) {
		 System.out.println("on delete "+idC+" for rec "+idR);
		// get allrec
		 Recruteure rec = r.getId(idR);
		 if(rec != null) {
			 System.out.println("user in "+rec.getNom());
			 List<Offre> offers = rec.getOffres();
			 Offre toDel = offers.stream()
					 .filter(of -> idC == of.getNum_offre())
					 .findAny()
					 .orElse(null);
			 System.out.println("DELETE -> " + toDel.toString());
			 if (toDel != null) {
				 offers.remove(toDel);
				 System.out.println("new offers "+offers.size());
				 rec.setOffres(offers);
				 r.update(rec);
				 or.Delete(idC);
			 }
		 } else {
			 System.out.println("user in not found");
		 } 
	  }
	@GetMapping("/getc/{id}")
	Offre getById (@PathVariable Long id){
		return or.getId(id);
	}
	@GetMapping("/getbytitre/{nom}")
	Iterable<Offre> getOffre(@PathVariable  String nom){
		if(nom != "") {
		return or.getOffreByNom(nom);
		}else return null;
	}
	@GetMapping("/getnom/{str}")
	Iterable<Offre> getnom(@PathVariable  String str){
		if(str != "") {
		return or.getOffreContaining(str);
		}else return null;
	}
	@PutMapping("/update/{id}")
    public Offre modifOffre(@PathVariable Long id,@RequestBody Offre offre){
        if (offre != null && id!= null) {
            return or.Update(id, offre);
        }
        return null;
    }
	@PutMapping("/updateCandidat/{id}")
    public Offre modifOffr (@PathVariable  Long id , @RequestBody Offre offre){
        if (offre != null  && k.findById(id).get()!= null) {
            return or.Update1( offre , id);
        }
        return null;
    }


}
