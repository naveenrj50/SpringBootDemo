package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {

	
   @Autowired
   public AlienRepo alienRepo;
	
	@RequestMapping("/getAlien/{id}")
	public Alien getAlien(@PathVariable("id") int id){
		
		Alien alien = alienRepo.findById(id).orElse(new Alien());
		return alien;
	}
	
	@RequestMapping("/addAlien")
	public Alien getAlien(Alien alien){
		
		alienRepo.save(alien);
		return alien;
	}
	
	
	@RequestMapping("/aliens")
	public List<Alien> getAliens(){
		
		
		return alienRepo.findAll();
	}
}
