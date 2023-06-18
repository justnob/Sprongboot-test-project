package com.amarnath.example.myapi.apicontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.amarnath.example.myapi.application.LaptopsDetails;
import com.amarnath.example.myapi.data.LaptopRepository;

@RestController
public class LaptopApiController {

	private LaptopRepository repo;

	public LaptopApiController(LaptopRepository repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/laptops")
	private List<LaptopsDetails> GetAllLaptops() {

		List<LaptopsDetails> allLaptops = repo.getAllLaptops();

		if (allLaptops.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NO_CONTENT);

		}

		return allLaptops;

	}

	@GetMapping("/laptops/{id}")
	private LaptopsDetails GetLaptopById(@PathVariable int id) {

		Optional<LaptopsDetails> laptopById = repo.getLaptopById(id);

		if (laptopById.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}

		return laptopById.get();
	}
	
	@GetMapping("/laptops/model/{mf}")
	private List<LaptopsDetails> GetLaptopsByManufactuer(@PathVariable String mf){
		
		List<LaptopsDetails> laptopsByManufactuer = repo.getLaptopsByManufactuer(mf);
		
		if (laptopsByManufactuer.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}
		
		return laptopsByManufactuer;
	}

}
