package com.zensar.olxapplication.service;

import java.util.List;


import com.zensar.olxapplication.Dto.OlxDto;

public interface OlxService {
	List<OlxDto> getAllUser(int pageNumber,int pageSize);

	String signInDetails(String userName, String password, String token);

	OlxDto createOlxUser(OlxDto olx, String token);

	String deleteUser(int userId);

}
