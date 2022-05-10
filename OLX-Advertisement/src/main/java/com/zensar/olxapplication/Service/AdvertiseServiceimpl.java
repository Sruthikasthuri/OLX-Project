package com.zensar.olxapplication.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zensar.olxapplication.Advertise;
import com.zensar.olxapplication.Dto.olxAdvertiseDto;
import com.zensar.olxapplication.Repository.AdvertiseRepository;

public class AdvertiseServiceimpl implements AdvertiseService {

	@Autowired
	private AdvertiseRepository advertiesRepository;

	private ModelMapper modelMapper = new ModelMapper();

	Advertise olxAdverities = new Advertise();
	static List<Advertise> userAdvertiesDetails = new ArrayList<Advertise>();

	static {
		userAdvertiesDetails.add(new Advertise(1,"Laptop sale","54000","electronic good","Intel core 3 sony viao","sruthi","1998","2022","open"));
	}
	@Override
	public olxAdvertiseDto createOlxUser(olxAdvertiseDto olxRequest, String token) {
		Advertise newOlx = modelMapper.map(olxRequest, Advertise.class);

		if (token.equals("sk66631")) {
			Advertise olx1 = advertiesRepository.save(newOlx);
			return modelMapper.map(olx1, olxAdvertiseDto.class);

		} else {
			return null;
		}
	}

	@Override
	public List<olxAdvertiseDto> getAll() {
		List<Advertise> ListOlx = advertiesRepository.findAll();
		//List<OlxAdverties> content = pageOlx.getContent();
		List<olxAdvertiseDto> olxAdvertiseResponses = new ArrayList<>();
		for (Advertise stock : userAdvertiesDetails) {
			olxAdvertiseDto olx1 = modelMapper.map(stock, olxAdvertiseDto.class);
			olxAdvertiseResponses.add(olx1);
		}
		return olxAdvertiseResponses;
	}

	@Override
	public olxAdvertiseDto getSpecificAdd(int id) {
		
		Advertise olxResponse = advertiesRepository.findById(id).get();
		return modelMapper.map(olxResponse, olxAdvertiseDto.class);
	}

	@Override
	public olxAdvertiseDto updateStock(int id, olxAdvertiseDto olxrequest) {
		
		olxAdvertiseDto olxResponse = getSpecificAdd(id);

		Advertise olx1 = modelMapper.map(olxrequest, Advertise.class);

		Advertise olx2 = advertiesRepository.save(olx1);
		return modelMapper.map(olx2, olxAdvertiseDto.class);
	}

	@Override
	public String deleteUser(int id) {
		for (Advertise olx : userAdvertiesDetails) {
			if (olx.getAdvertiseId() == id) {
				userAdvertiesDetails.remove(olx);
				return "Deleted successfully!!";
			}
		}
		return " failed!!!";
	}

}
