package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.languages.CreateLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.DeleteLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.languages.UpdateLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.languages.GetAllLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.languages.GetProgrammingLanguageById;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	GetProgrammingLanguageById getProgrammingLanguageById(int id)throws Exception;

}
