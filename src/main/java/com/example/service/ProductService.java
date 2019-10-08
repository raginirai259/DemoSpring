package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.Product;
import com.example.exceptions.ProductNotFoundExecption;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;

	public String addProduct(Product product) {
		
		pr.addProduct(product);
		
		return "Products" +product + "are added successfully" ;
		
	}
	
	
	public List<Product> fetchprod()
	{
		
		return pr.fetchprod();
	}


	public String updateProduct(double productPrice, Product product) {
	
		String response="Product of" +productPrice +"does not exist";
		for(Product prod:pr.fetchprod())
		{
			if(prod.getProductPrice()==productPrice) {
				
				response="Product of" +productPrice +"Updated successfully";
			}
		}
		
		return response;
	}
	
	
	
	public String deleteProduct(int productId) {
		
		String response="Product of" +productId +"does not exist";
				
		for(Product prod:pr.fetchprod())
		{
			if(prod.getProductId()==productId)
			{
				
				pr.deleteProduct(prod);
				response="Product of" +productId +"Deleted successfully";
				break;
				
			}
		}
		
		return response;
		
	}
	
	
	public  List<Product> fetchproddetails(String productName,String productVender)
	{
		return pr.fetchproddetails(productName,productVender);
		
		
	}


	public List<Product> getProducts(List ls) {
		
		return pr.getProducts(ls);
	}


	public String deleteProductCode(long productCode) throws ProductNotFoundExecption {
		
		return pr.deleteProductCode(productCode);
		
	}
}
