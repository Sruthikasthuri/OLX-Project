package com.zensar.olxapplication.Service;

import java.util.List;

import com.zensar.olxapplication.category;
import com.zensar.olxapplication.status;
import com.zensar.olxapplication.Dto.olxMasterDto;

public interface MasterService {
	public List<olxMasterDto> getAllCategories();
	public List<olxMasterDto> getAllStatuses();

}
