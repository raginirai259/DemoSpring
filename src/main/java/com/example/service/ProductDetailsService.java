package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Product_details;
import com.example.repository.ProductDetailsRepo;

@Service
public class ProductDetailsService {

	@Autowired 
	private ProductDetailsRepo pdrepo;
	
	
	public Product_details fetchbyName(String name)
	{
		return pdrepo.fetchbyName(name);
	}
	
}
