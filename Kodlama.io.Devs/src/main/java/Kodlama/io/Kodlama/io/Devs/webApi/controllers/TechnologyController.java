package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologiesService;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.technology.GetSubTechnologyResponse;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
	private TechnologiesService technologiesService;
	@Autowired
	public TechnologyController(TechnologiesService technologiesService) {
		this.technologiesService=technologiesService;
	}
	@GetMapping("/getAll")
	public List<GetAllTechnologyResponse> getAll(){
		return technologiesService.getAll();
	}
	
	@PostMapping("/add-technology")
	public void add(CreateTechnologyRequest createTechnologyRequest)throws Exception{
		 technologiesService.add(createTechnologyRequest);
	}
	@DeleteMapping("/delete-technology")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest)throws Exception{
		technologiesService.Delete(deleteTechnologyRequest);
	}
	@PutMapping("/update-technology")
	public void update(UpdateTechnologyRequest updateTechnologyRequest)throws Exception{
		technologiesService.Update(updateTechnologyRequest);
	}
	@GetMapping("/findById/{id}")
	public GetSubTechnologyResponse getSubTechnologyResponse(@PathVariable int id) throws Exception{
		return technologiesService.findById(id);
	}

}
