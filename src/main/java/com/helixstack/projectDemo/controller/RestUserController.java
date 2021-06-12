package com.helixstack.projectDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.helixstack.projectDemo.helper.CSVHelper;
import com.helixstack.projectDemo.model.HubSpotResult;
import com.helixstack.projectDemo.model.User;
import com.helixstack.projectDemo.repository.UserRepository;
import com.helixstack.projectDemo.service.CSVService;
import com.helixstack.projectDemo.service.UserService;

@RestController
public class RestUserController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	UserRepository userRepo;
	
	@PostMapping("/saveUser")
	public List<User> saveUser(@RequestBody User user) {
		userRepo.save(user);
		return (List<User>) userRepo.findAll();
	}
	
	@GetMapping("/getAllUsers")
	public Object getAll() {
		return userRepo.findAll();
	}
	
	@Autowired
	CSVService fileService;

	  @PostMapping("/upload")
	  public Object uploadFile(@RequestParam MultipartFile file) {
	    String message = "";

	    if (CSVHelper.hasCSVFormat(file)) {
	    	System.out.print("Processing file");
	      try {
	        fileService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return "Data inserted";
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return "Failed to save "+ e;
	      }
	    }

	    message = "Please upload a csv file!";
	    return "Please Upload file";
	  }
	  
	  @PostMapping("/processContacts")
	  public int processContacts(@RequestBody List<HubSpotResult> results) {
	   System.out.println("processing contacts");
	   return userService.mapContacts(results);
	  }
	  
}
