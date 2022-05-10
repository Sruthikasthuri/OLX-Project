package com.zensar.olxapplication.Dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zensar.olxapplication.Advertise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class olxAdvertiseDto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int advertiseId;
	private String advertiseTitle;
	private String advertisePrice;
	private String advertiseCategory;
	private String advertiseDescription;
	private String userName;
	private String createdDate;
	private String modifiedDate;
	private String status;

}
