package com.zensar.olxapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.Dto.olxMasterDto;
import com.zensar.olxapplication.Service.MasterService;

@RestController
public class MyadvertiseController {

	@Autowired
	private MasterService masterService;

	
	@RequestMapping(value = "/advertise/category", method = RequestMethod.GET)
	public List<olxMasterDto> getAllAdd() {

		return masterService.getAllCategories();

	}

	@RequestMapping(value = "/advertise/status", method = RequestMethod.GET)
	public List<olxMasterDto> getStatusList() {

		return masterService.getAllStatuses();

	}
}