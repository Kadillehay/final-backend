package com.coderscampus.api.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.FarmDetails;
import com.coderscampus.api.domain.User;
import com.coderscampus.api.repository.FarmDetailsRepository;
import com.coderscampus.api.repository.FarmRegisterRepository;

@RestController
@CrossOrigin(origins="*")
public class FarmDetailsController {
	
	@Autowired
	private FarmDetailsRepository repository;
	
	@Autowired
	private FarmRegisterRepository farmRegisterRepository;
	@PostMapping("/send-details")
	public ResponseEntity <FarmDetails> sendDetails(@RequestBody FarmDetails details){
		FarmDetails newDetails = new FarmDetails();
		BeanUtils.copyProperties(details, newDetails);
		User foundUser = farmRegisterRepository.findById(details.getUserId()).get();
		foundUser.setFarmDetails(newDetails);
		newDetails.setUser(foundUser);
		repository.save(newDetails);
		
		
		
		
		
		return ResponseEntity.ok(newDetails);
		
		
	}
	@GetMapping("/get-details")
	public ResponseEntity <List<FarmDetails>> sendDetails(){
		
		
		List<FarmDetails> list = repository.findAll();
		return ResponseEntity.ok(list);
		
	}
	
	
	
}
