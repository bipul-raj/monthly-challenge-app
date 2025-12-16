package com.springboot.restapis.monthlyChallengeApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restapis.monthlyChallengeApp.controller.Challenge;

@Service
public class ChallengeService {
	
	private List<Challenge> challenges= new ArrayList<>();
	private Long nextId=1L;
	
	public ChallengeService() {
		//Challenge challenge1= new Challenge(1L, "January", "Learn REST API");
		//challenges.add(challenge1);
	}

	public List<Challenge> getAllChallenges() {
		return challenges;
	}
	
	public boolean createChallenges(Challenge challenge) {
		if(challenge!=null) {
			challenge.setId(nextId++);
			challenges.add(challenge);
			return true;
		}
		else return false;
	}

	public Challenge getMonthlyChallenge(String month) {
		for (Challenge challenge : challenges) {
			if(challenge.getMonth().equalsIgnoreCase(month)) {
				return challenge;
			}
		}
		return null;
	}

	public boolean updateMonthlyChallenge(Long id, Challenge updatedChallenge) {
		for (Challenge challenge : challenges) {
			if(challenge.getId().equals(id)) {
				challenge.setMonth(updatedChallenge.getMonth());
				challenge.setDescription(updatedChallenge.getDescription());
				return true;
			}
		}
		return false;
	}

}
