package org.sesame.gestionrecrutement.controller;



import java.nio.file.Files;
import java.nio.file.Paths;

import org.sesame.gestionrecrutement.Repository.CvRepository;
import org.sesame.gestionrecrutement.entities.Cv;
import org.sesame.gestionrecrutement.interfac.CvInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping ("/candidat/cv")
public class CvController {
	@Autowired
	private CvInterface cr;
	@Autowired
	private CvRepository ce;
	 @PostMapping("/add")
	 Cv ajoutcv(@RequestBody Cv c) {
			if(c !=null) {
				return cr.add(c);
				
			}
			return null;
			
		}
	   @GetMapping ("/get")
		Iterable<Cv> getAll(){
			return  cr.getAll();
			
		}
	   @DeleteMapping("/delet/{idC}")
		  void deletCv(@PathVariable Long idC) {
			  cr.Delete(idC);
		  }
		  @GetMapping("/get/{id}")
		  Cv getCv(@PathVariable  Long id) {
			return  cr.getId(id);
			}
		  
		  @GetMapping( path = "/photo/{num_cv}", produces = org.springframework.http.MediaType.IMAGE_PNG_VALUE)
			public byte[] getphoto(@PathVariable("num_cv")Long num_cv) throws Exception {
			  Cv c = ce.findById(num_cv).get();
			 return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/cv/"+c.getContenue()));
		  }
		  
		  
		  @PostMapping(path = "/uploadCv/{num_cv}")
		  public void uploadCv(MultipartFile file, @PathVariable Long num_cv) throws Exception {
			  Cv c = ce.findById(num_cv).get();
			  c.setContenue(file.getOriginalFilename());
			  Files.write(Paths.get(System.getProperty("user.home")+"/cv/"+c.getContenue()), file.getBytes());
			  
			  ce.save(c);
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

}
