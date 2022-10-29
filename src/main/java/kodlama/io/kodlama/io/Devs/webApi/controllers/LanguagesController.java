package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.entities.concretes.Language;


@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}	

	@GetMapping("/getall")
	public List<Language> getAll(){
		return languageService.getAll();		
	}

	@GetMapping("/{id}")
	public Language getById(@PathVariable(name = "id")int id) throws Exception{
		return languageService.getById(id);
	}
	
	@PostMapping
	public Language add(@RequestBody Language language) throws Exception{
		return languageService.add(language);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id)throws Exception{
		languageService.delete(id);
		return ("Silindi!");
	}
	
	@PutMapping("/{id}")
	public void updateById(@PathVariable int id, @RequestBody Language language) throws Exception{
		languageService.update(language, id);
	}   
		
}










