package com.zensar.olxapplication.service;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.zensar.olxapplication.User;
import com.zensar.olxapplication.Dto.OlxDto;
import com.zensar.olxapplication.Repository.olxLoginRepository;

public class OlxServiceimpl implements OlxService {
	@Autowired
	private olxLoginRepository olxRepository;
	
	//private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	private ModelMapper modelMapper;

	User user = new User();
	
	  static List<User> userDetails = new ArrayList<User>();
	  
	  static { userDetails.add(new User(1,"sruthi","kasthuri","sruthi","sruthi@123","kasthuri@gmail.com","8106750501")); 
	  }

	@Override
	public String signInDetails(String userName, String password, String token) {
		user.setUserName("sruthi");
		user.setPassword("sruthi5050");
		if (token.equals("sruthi123")) {
			if (user.getUserName().equals("sruthi") && user.getPassword().equals("sruthi5050")) {
				return "Login Successfully!!!";
			} else {
				return "Sorry, Authentication Failed";
			}
		}
		return "Invalid Token";

	}

	@Override
	public OlxDto createOlxUser(OlxDto olxRequest, String token) {
		
      User newuser= modelMapper.map(olxRequest, User.class);
		

		if (token.equals("sk66631")) {
			 User user1 = olxRepository.save(newuser);
			return modelMapper.map(user1, OlxDto.class);

		} else {
			return null;
		}
	}

	@Override
	public String deleteUser(int userId) {
		for (User user : userDetails) {
			if (user.getId() == userId) {
				userDetails.remove(user);
				return "user deleted Successfully" + userId;
			}
		}
		return "Sorry user is not available";

	}


	private OlxDto mapToResponse(User user) {

		OlxDto olxResponse = new OlxDto();

		olxResponse.setId(user.getId());

		olxResponse.setFirstName(user.getFirstName());
		
		olxResponse.setLastName(user.getLastName());
		
		olxResponse.setUserName(user.getUserName());
		
		olxResponse.setPassword(user.getPassword());
		
		olxResponse.setEmail(user.getEmail());
		
		olxResponse.setPhone(user.getPhone());
		
		
		return olxResponse;

	}
	@Override
	public List<OlxDto> getAllUser(int pageNumber, int pageSize) {
		Page<User> pageOlx = olxRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<User> page = pageOlx.getContent();

		List<OlxDto> olxResponses = new ArrayList<>();

		for (User user : page) {
			
			OlxDto response=modelMapper.map(pageOlx, OlxDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}


}
