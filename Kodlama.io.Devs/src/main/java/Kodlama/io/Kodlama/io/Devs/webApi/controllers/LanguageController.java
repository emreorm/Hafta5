package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.CreateLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.DeleteLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.UpdateLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.languages.GetAllLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.languages.GetProgrammingLanguageById;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/GetAll")
	public List<GetAllLanguageResponse> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/findById")
	public GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception{
		return languageService.getProgrammingLanguageById(id);
	}

	@PostMapping("/add-language")
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}

	@PutMapping("/update-language")
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}

	@DeleteMapping("delete-language")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}

}
