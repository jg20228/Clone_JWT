package com.homewc.jwtclone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homewc.jwtclone.db.UserRepository;
import com.homewc.jwtclone.model.User;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
	private UserRepository userRepository;
	
	public PublicRestApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Available to all authenticated users
	@GetMapping("test")
	public String test1() {
		return "API Test";
	}
	
	//Available to managers
	@GetMapping("management/reports")
	public String reports() {
		return "Some report data";
	}
	
	// Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}
