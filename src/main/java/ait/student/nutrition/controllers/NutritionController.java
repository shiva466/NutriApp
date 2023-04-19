package ait.student.nutrition.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ait.student.nutrition.nutrition.dto.supplier;
import ait.student.nutrition.rep.NutritionRepository;

@RestController
@Service
@RequestMapping("/")

public class NutritionController 
{
	@Autowired
	NutritionRepository repo;
	@GetMapping(value="/getsuppliers")
	List<supplier> getApplicationForCategory() 
	{
		return repo.findAll(Sort.by("item").descending());
	}
	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.GET)
	public 
	Optional<supplier> getApplication(@PathVariable("id") Long id) 
	{ 
		return repo.findById(id); 
	}
	
	@RequestMapping(value = "/supplier", method = RequestMethod.POST)
	public supplier create(@RequestBody supplier supplier)
	{
		return repo.save(supplier);
	}
	
	
	
}
