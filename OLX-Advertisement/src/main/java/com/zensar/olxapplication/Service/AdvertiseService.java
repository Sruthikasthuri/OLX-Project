package com.zensar.olxapplication.Service;

import java.util.List;

import com.zensar.olxapplication.Advertise;
import com.zensar.olxapplication.Dto.olxAdvertiseDto;

public interface AdvertiseService {
	olxAdvertiseDto createOlxUser(olxAdvertiseDto olx, String token);
	List<olxAdvertiseDto> getAll();
	olxAdvertiseDto getSpecificAdd(int id);
	olxAdvertiseDto updateStock(int id, olxAdvertiseDto olxrequest);
	String deleteUser(int id);
}
