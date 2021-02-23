package com.codingdojo.DojosAndNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.repos.DojoRepo;


@Service
public class DojoService {
	
    // adding the dojo repository as a dependency
	@Autowired
    private DojoRepo dojoRepo;
    
    // returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepo.save(b);
    }
    
    // save a dojo
    public Dojo updateDojo(Dojo b) {
        return dojoRepo.save(b);
    }
    
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
