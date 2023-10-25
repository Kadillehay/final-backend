package com.coderscampus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.api.domain.FarmDetails;
import com.coderscampus.api.domain.User;

public interface FarmDetailsRepository extends JpaRepository <FarmDetails, Long> {
	
	FarmDetails findByUser(User user);

}
