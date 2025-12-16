package com.springboot.restapis.monthlyChallengeApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapis.monthlyChallengeApp.services.ChallengeService;

@RestController
public class ChallengeController {
	
	private ChallengeService challengeService;
	
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService=challengeService;
	}
	
	@GetMapping("/challenges")
	public ResponseEntity<List<Challenge>> getAllChallenges(){
		return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
	}
	
	@GetMapping("/challenges/{month}")
	public ResponseEntity<Challenge> getMonthlyChallenge(@PathVariable String month){
		Challenge challenge= challengeService.getMonthlyChallenge(month);
		if(challenge!=null) {
			return new ResponseEntity<>(challenge,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/challenges")
	public ResponseEntity<String> createChallenges(@RequestBody Challenge challenge) {
		boolean isChallengeCreated= challengeService.createChallenges(challenge);
		
		if(isChallengeCreated) {
			return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
		}
		else return new ResponseEntity<>("Challenge is not added",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/challenges/{id}")
	public ResponseEntity<String> updateMonthlyChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
		boolean isChallengeUpdated= challengeService.updateMonthlyChallenge(id,updatedChallenge);
		if(isChallengeUpdated) {
			return new ResponseEntity("Challenge updated successfully",HttpStatus.OK);
		}
		else return new ResponseEntity("Challenge is not updated",HttpStatus.NOT_FOUND); 
	}

}
