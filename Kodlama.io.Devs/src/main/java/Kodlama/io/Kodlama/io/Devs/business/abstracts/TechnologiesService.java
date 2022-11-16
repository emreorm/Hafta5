package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.technology.GetSubTechnologyResponse;

public interface TechnologiesService  {
	List<GetAllTechnologyResponse> getAll();
	GetSubTechnologyResponse findById(int id)throws Exception;
	
	
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void Delete(DeleteTechnologyRequest deleteTechnologyRequest)throws Exception;
	void Update(UpdateTechnologyRequest updateTechnologyRequest)throws Exception;
}
