package com.helixstack.projectDemo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.helixstack.projectDemo.helper.CSVHelper;
import com.helixstack.projectDemo.model.User;
import com.helixstack.projectDemo.repository.UserRepository;

@Service
public class CSVService {
	 @Autowired
	 UserRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<User> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
	      repository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<User> getAllTutorials() {
	    return (List<User>) repository.findAll();
	  }
	}
