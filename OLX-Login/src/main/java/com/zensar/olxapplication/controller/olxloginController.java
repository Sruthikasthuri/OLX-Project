package com.zensar.olxapplication.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.User;
import com.zensar.olxapplication.Dto.OlxDto;
import com.zensar.olxapplication.service.OlxService;

//@Controller
@RequestMapping("/user")
@RestController
public class olxloginController {

	@Autowired
	private OlxService olxService;
	


	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> createOlxUser(@RequestBody OlxDto olx, @RequestHeader("auth-token") String token) {
		OlxDto olxResult = olxService.createOlxUser(olx, token);
		if (olxResult == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<User>(HttpStatus.CREATED);
		}
	}

	@GetMapping("/user")
	public List<OlxDto> getAllUser(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return olxService.getAllUser(pageNumber, pageSize);

	}

	// @PostMapping
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
	public String signInDetails(@RequestBody(required = false) String userName,
			@RequestBody(required = false) String password, @RequestHeader("auth-token") String token) {
		return olxService.signInDetails(userName, password, token);

	}

	@DeleteMapping("/user/logout/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return olxService.deleteUser(userId);

	}
}

