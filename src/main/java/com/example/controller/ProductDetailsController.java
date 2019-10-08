package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Product;
import com.example.dto.Product_details;
import com.example.service.ProductDetailsService;
import com.example.service.ProductService;

@RestController
@RequestMapping("/getproducts")
public class ProductDetailsController {

	@Autowired
	ProductService ps;
	@Autowired
	ProductDetailsService pds;
	@GetMapping
	public List<Product> getProducts(@RequestParam("productName")String productName,@RequestParam("productVender")String productVender)
	{
		
		return ps.fetchproddetails(productName,productVender);
		 
	
	}
	
	@GetMapping("/{name}")
	public Product_details fetchbyName(@PathVariable("name")String name) {
		return pds.fetchbyName(name);
	}
	
}
