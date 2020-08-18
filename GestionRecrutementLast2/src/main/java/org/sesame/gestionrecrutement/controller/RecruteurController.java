package org.sesame.gestionrecrutement.controller;


import org.sesame.gestionrecrutement.entities.Recruteure;
import org.sesame.gestionrecrutement.interfac.RecruteureInterface;
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
@RequestMapping ("/recruteur")
public class RecruteurController {
	@Autowired
	private RecruteureInterface r;
	@PostMapping("/add")
	Recruteure ajoutRecruteur(@RequestBody Recruteure re) {
		if(re !=null) {
			return r.add(re);
			
		}
		return null;
		
	}
	@GetMapping ("/get")
	Iterable<Recruteure> getAll(){
		return r.getAll();
	}
	@DeleteMapping("/delet/{id}")
	  void deletRecruteur(@PathVariable Long id) {
		  r.Delete(id);
	  }
	@GetMapping("/getc/{id}")
	Recruteure getById (@PathVariable Long id){
		return r.getId(id);
	}
	@GetMapping("/getnom/{nom}")
	Iterable<Recruteure> getRecruteur(@PathVariable  String nom){
		if(nom != "") {
		return r.getOffreByNom(nom);
		}else return null;
	}

}
