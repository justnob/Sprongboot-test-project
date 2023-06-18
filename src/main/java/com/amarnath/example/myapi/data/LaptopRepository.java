package com.amarnath.example.myapi.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.amarnath.example.myapi.application.LaptopsDetails;

@Repository
public class LaptopRepository {

	private static List<LaptopsDetails> laptopDetails = new ArrayList<>();
	
	static{
		
		LaptopsDetails laptopDetails1 = new LaptopsDetails((long) 1, "HP-300", "Hp");
		LaptopsDetails laptopDetails2 = new LaptopsDetails((long) 2, "Latitude 7430", "Dell");
		
		
		List<LaptopsDetails> allLaptops = new ArrayList<>(Arrays.asList(laptopDetails1, laptopDetails2));

		laptopDetails.addAll(allLaptops);
		
	}

	public List<LaptopsDetails> getAllLaptops() {
		
		return laptopDetails;
		
	}

	public Optional<LaptopsDetails> getLaptopById(int id) {
		
		
		Predicate<? super LaptopsDetails> predicate = (l -> l.getId() == id);
		Optional<LaptopsDetails> laptopsDetailsById = getAllLaptops().stream().filter(predicate).findFirst();
		
		if (laptopsDetailsById.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}
		
		return laptopsDetailsById;
		
	}

	public List<LaptopsDetails> getLaptopsByManufactuer(String mf) {
		
		Predicate<? super LaptopsDetails> predicate = (m -> m.getManufature().equalsIgnoreCase(mf));
		 List<LaptopsDetails> filter = (List<LaptopsDetails>) getAllLaptops().stream().filter(predicate).toList();
		
		 if (filter.isEmpty()) {

				throw new ResponseStatusException(HttpStatus.NOT_FOUND);

			}
		 
		return filter;
		
	}
	
}
