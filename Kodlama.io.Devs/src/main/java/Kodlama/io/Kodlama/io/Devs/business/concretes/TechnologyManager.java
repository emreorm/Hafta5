package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologiesService;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.technology.GetSubTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologiesService {
	private TechnologyRepository technologyRepository;
	

	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();
		for (Technology technology : technologies) {
			GetAllTechnologyResponse getAllTechnologyResponse = new GetAllTechnologyResponse();

			getAllTechnologyResponse.setTechnologyId(technology.getId());
			getAllTechnologyResponse.setTechnologyName(technology.getName());
			

			technologyResponses.add(getAllTechnologyResponse);

		}

		return technologyResponses;
	}

	@Override
	public void add(CreateTechnologyRequest createRequest) {
		// Languages language = languageRepository.getReferenceById(createRequest.ge

		Technology technology = new Technology();
		technology.setName(createRequest.getName());

		this.technologyRepository.save(technology);

	}

	@Override
	public void Delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		Technology technology = new Technology();
		technology.setId(deleteTechnologyRequest.getId());
		this.technologyRepository.delete(technology);

	}

	@Override
	public void Update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		List<Technology> technologies = technologyRepository.findAll();

		for (Technology technology : technologies) {
			if (updateTechnologyRequest.getId() == technology.getId()) {
				technology.setName(updateTechnologyRequest.getName());
				this.technologyRepository.save(technology);

			} else {
				System.out.println("Update fail!");
			}
		}
	}

	@Override
	public GetSubTechnologyResponse findById(int id) throws Exception {
		List<Technology> subTechnologies = technologyRepository.findAll();
		GetSubTechnologyResponse getSubTechnologyResponse = new GetSubTechnologyResponse();
		for (Technology technology2 : subTechnologies) {
			if (technology2.getId() == id) {
				getSubTechnologyResponse = new GetSubTechnologyResponse();
				getSubTechnologyResponse.setId(technology2.getId());
				getSubTechnologyResponse.setName(technology2.getName());
			}

		}
		return getSubTechnologyResponse;
	}

}
