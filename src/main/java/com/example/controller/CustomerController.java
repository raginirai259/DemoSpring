package com.example.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.naming.directory.NoSuchAttributeException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ErrorMessage;
import com.example.dto.Product;
import com.example.exceptions.ProductNotFoundExecption;
import com.example.service.ProductService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ProductService ps;

	/*
	 * @GetMapping public String fetchCustomer() {
	 * 
	 * Calendar cal = Calendar.getInstance();
	 * 
	 * int day = cal.get(Calendar.DAY_OF_WEEK); String[] strDays = new String[] {
	 * "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"
	 * };
	 * 
	 * return "Welcome to " + strDays[day - 1] + " sale"; }
	 */
	
	  
	  
	  @GetMapping(produces="application/json")
	  public List<Product> fetchprod() { 
		  return ps.fetchprod(); 
		  
	  }
	 

	@PostMapping(consumes = "application/json")
	@RequestMapping(value = "/product")
	public ResponseEntity addProduct(@Valid @RequestBody Product product,Errors errors) {
		String response="";
		
		if(errors.hasErrors()){
			
			response=errors.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
			
			ErrorMessage em=new ErrorMessage();
			em.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
			em.setMessage(response);
			
			return ResponseEntity.ok(em);
			
		}
		else {
		 response = ps.addProduct(product);

		return ResponseEntity.ok(response);
		}
		
	}

	
	@PutMapping(value="/{productPrice}")
	public String updateProduct(@PathVariable double productPrice,@RequestBody Product product) {
		
			
		return ps.updateProduct(productPrice,product);
		
		
	}
	
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer id) 
	{
		return ps.deleteProduct(id);
		
	}
	
	List<Product> lp;
	
	@GetMapping(value="/{query}/productdetail",produces= {"application/json"})
		public List<Product> getProducts(@MatrixVariable(pathVar="query") Map<String,List<String>> map)
	{
		Set<String> st=map.keySet();
		
		List ls=new ArrayList();
		for(String key:st) {
			
		for(int i=0;i<map.get(key).size();i++) {
			
			ls.add(map.get(key).get(i));
		}
		
		}
		lp=ps.getProducts(ls);
		return lp;
		
		
	}
	
	
	
	@DeleteMapping("/product/{productCode}")
	public String deleteProduct(@PathVariable("productCode") long productCode) throws ProductNotFoundExecption
	{
		return ps.deleteProductCode(productCode);
	}

}
