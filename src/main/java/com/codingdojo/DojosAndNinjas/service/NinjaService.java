package com.codingdojo.DojosAndNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.repos.NinjaRepo;


@Service
public class NinjaService {
    // adding the ninja repository as a dependency
	@Autowired
    private NinjaRepo ninjaRepo;
    
    // returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    
    // creates a ninja
    public Ninja createNinja(Ninja b) {
        return ninjaRepo.save(b);
    }
    
    // save a ninja
    public Ninja updateNinja(Ninja b) {
        return ninjaRepo.save(b);
    }
    
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
}


