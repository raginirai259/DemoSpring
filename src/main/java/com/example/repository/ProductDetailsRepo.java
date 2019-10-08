package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.dto.Product_details;

@Repository
public class ProductDetailsRepo {
	
	private List<Product_details> pdetails;
	@PostConstruct
	public void initializer() {
		pdetails=new ArrayList();
		Product_details pdet=new Product_details();
		pdet.setName("Ragini");
		pdet.setProfession("HR");
		
		pdetails.add(pdet);
		
		
	}
	
	public Product_details fetchbyName(String name)
	
	{
		Optional<Product_details> opd=pdetails.stream().filter(x -> x.getName()==name).findFirst();
//		System.out.println("1: "+opd.orElse(pdetails.get(1)));
//		System.out.println("0: "+opd.orElse(pdetails.get(0)));
//		System.out.println("2: "+opd.orElse(pdetails.get(2)));
		return opd.orElse(pdetails.get(0));
	}

}
