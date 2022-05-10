package com.zensar.olxapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zensar.olxapplication.Advertise;
import com.zensar.olxapplication.Dto.olxAdvertiseDto;
import com.zensar.olxapplication.Service.AdvertiseService;

public class AdvertiseController {
	@Autowired
	private AdvertiseService advertiseService;

	@RequestMapping(value = "/advertise", method = RequestMethod.POST)
	public ResponseEntity<Advertise> createOlxUser(@RequestBody olxAdvertiseDto olx,
			@RequestHeader("auth-token") String token) {
		olxAdvertiseDto olxAdd = advertiseService.createOlxUser(olx, token);
		if (olxAdd == null) {
			return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Advertise>(HttpStatus.CREATED);
		}
	}
	@RequestMapping(value = "user/advertise/{id}", method = RequestMethod.GET)
	public olxAdvertiseDto getSpecificAdd(@PathVariable("id") int id) {
		return advertiseService.getSpecificAdd(id);

	}
	@DeleteMapping("/user/advertise/{id}")
	public String deleteUser(@PathVariable int id) {
		return advertiseService.deleteUser(id);

	}
	@GetMapping(value = "/user/advertise")
	public List<olxAdvertiseDto> getAll() {

		return advertiseService.getAll();
	}

	

	@PutMapping("/advertise/{id}")
	public olxAdvertiseDto updateStock(@PathVariable("id") int id, @RequestBody olxAdvertiseDto olxAdverties) {
		return advertiseService.updateStock(id, olxAdverties);
	}

	

}
