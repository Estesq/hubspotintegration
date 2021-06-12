package com.helixstack.projectDemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.helixstack.projectDemo.helper.CSVHelper;
import com.helixstack.projectDemo.model.ResponseObj;
import com.helixstack.projectDemo.model.User;
import com.helixstack.projectDemo.repository.ResponseObjectRepository;
import com.helixstack.projectDemo.repository.UserRepository;
import com.helixstack.projectDemo.service.CSVService;
import com.helixstack.projectDemo.util.CsvUtils;

import springfox.documentation.service.ResponseMessage;

@Controller
public class UserController {
	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	ResponseObjectRepository resRepo;
	
	  @GetMapping("/getIndex")
	  public String getPage(Model model) {
		  return "index";
	  }
	  
	  @GetMapping("/download/contact.csv")
	    public void downloadCsv(HttpServletResponse response) throws IOException {
	        response.setContentType("text/csv");
	        response.setHeader("Content-Disposition", "attachment; file=employee.csv");
	        CsvUtils.downloadCsv(response.getWriter(), createTestData()) ;
	    }
	  
	  private List<ResponseObj> createTestData() {
	        List<ResponseObj> data =(List<ResponseObj>) resRepo.findAll();
	        return data;
	    }
}
