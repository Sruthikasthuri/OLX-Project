package com.zensar.olxapplication;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statusId;
	private String statusName;
	public List<status> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
