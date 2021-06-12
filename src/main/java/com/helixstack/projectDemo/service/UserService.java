package com.helixstack.projectDemo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.helixstack.projectDemo.model.HubSpotResult;
import com.helixstack.projectDemo.model.ResponseObj;
import com.helixstack.projectDemo.model.User;
import com.helixstack.projectDemo.repository.ResponseObjectRepository;
import com.helixstack.projectDemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	ResponseObjectRepository resRepo;
	
	public int mapContacts(List<HubSpotResult> results) {

	    HashMap<String, HubSpotResult> resultMap = new HashMap<>();
	    for(HubSpotResult item: results) {
	    	resultMap.put(item.getProperties().getEmail(), item);
	    }
	    List<User> users = (List<User>) userRepo.findAll();
	    List<ResponseObj> res = new ArrayList<>();
	    for(User user: users) {
	    	ResponseObj obj = new ResponseObj();
	    	obj.setEmail(user.getEmail());
	    	obj.setFirstName(user.getFirst_name());
	    	obj.setLastName(user.getLast_name());
	    	if(resultMap.containsKey(user.getEmail())) {
	    		HubSpotResult item = resultMap.get(user.getEmail());
	    		obj.setCompanyName(item.getProperties().getCompany());
	    	}
	    	resRepo.save(obj);
	    	res.add(obj);
	    }
		return res.size();
	}

}
