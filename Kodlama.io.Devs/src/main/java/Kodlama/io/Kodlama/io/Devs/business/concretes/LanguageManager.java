package Kodlama.io.Kodlama.io.Devs.business.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.CreateLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.DeleteLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.UpdateLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.languages.GetAllLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.languages.GetProgrammingLanguageById;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	List<Language> languages;
    @Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	

	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponses = new ArrayList<GetAllLanguageResponse>();
		for (Language language : languages) {
			GetAllLanguageResponse responseItem= new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setLanguageName(language.getName());
			languageResponses.add(responseItem);
		}return languageResponses;
	}
	

	
	

	@Override
	public void add(CreateLanguageRequest createLanguageRequest)throws Exception {
		
		Language language = new Language();
        language.setName(createLanguageRequest.getName());

        List<Language> languages=languageRepository.findAll();
        for(Language language1:languages){
            if (language1.getName().equals(language.getName())){
                throw new Exception("Programming language already exist!");
            }
        }
        if(language.getName().isEmpty()){
            throw new Exception("Programmming language cannot be empty!");
        }
        this.languageRepository.save(language);
		
		
	}


	@Override
	public void update(UpdateLanguageRequest request)throws Exception {
		if (request.getName().isEmpty() || request.getName().isBlank()) {
			throw new Exception("Programlama ismi boş bırakılamaz");
		}
		
		else {
			Language language=languageRepository.findById(request.getId()).orElseThrow(()-> new Exception("Id does not found"));
			language.setName(request.getName());
			languageRepository.save(language);
		}
		
	}


	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language=new Language();
		language.setId(deleteLanguageRequest.getId());
		this.languageRepository.delete(language);
		
	}


	


	@Override
	public GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception {
		if(!this.languageRepository.findById(id).isPresent()) {
			throw new Exception("Id does not found!");
		}
		Language language = languageRepository.findById(id).get();
		GetProgrammingLanguageById getProgrammingLanguageById = new GetProgrammingLanguageById();
		getProgrammingLanguageById.setName(language.getName());
		return getProgrammingLanguageById;
	}
	
	
	}

	
	


