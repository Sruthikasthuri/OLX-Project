package com.zensar.olxapplication.Dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class olxMasterDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String categoryName;
	private int statusId;
	private String statusName;

}
