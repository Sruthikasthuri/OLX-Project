package com.zensar.olxapplication.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zensar.olxapplication.category;
import com.zensar.olxapplication.status;
import com.zensar.olxapplication.Dto.olxMasterDto;

public class MasterServiceimpl implements MasterService {

	@Autowired
	private category category;
	@Autowired
	private status status;
	
	private ModelMapper modelMapper=new ModelMapper();
	
	static List<category> userDetails = new ArrayList<category>();

	static {
		userDetails.add(new category(1, "Furniture"));
		userDetails.add(new category(2, "cars"));
		userDetails.add(new category(3, "mobiles"));
		userDetails.add(new category(4, "real estate"));
		userDetails.add(new category(5, "sports"));
	}
	
	static List<status> userStatus = new ArrayList<status>();
	
	static {
		userStatus.add(new status(1, "OPEN"));
		userStatus.add(new status(2, "CLOSED"));
		

	}

	@Override
	public List<olxMasterDto> getAllCategories() {
		List<category> statusOlx = category.findAll();
		
		List<olxMasterDto> olxResponses = new ArrayList<>();

		for (category olx : userDetails) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			olxMasterDto response=modelMapper.map(olx, olxMasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	@Override
	public List<olxMasterDto> getAllStatuses() {
		
		List<status> ListOlx = status.findAll();
	

		List<olxMasterDto> olxResponses = new ArrayList<>();

		for (status olx : userStatus) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			olxMasterDto response=modelMapper.map(olx, olxMasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	
	

	private olxMasterDto mapToResponse(category olx) {

		olxMasterDto olxResponse = new olxMasterDto();

		olxResponse.setCategoryId(olx.getCategoryId());

		olxResponse.setCategoryName(olx.getCategoryName());

		
		return olxResponse;

	}

	

	private olxMasterDto mapToResponse(status olx) {

		olxMasterDto olxResponse = new olxMasterDto();

		olxResponse.setStatusId(olx.getStatusId());

		olxResponse.setStatusName(olx.getStatusName());


		
		return olxResponse;

	}
}
