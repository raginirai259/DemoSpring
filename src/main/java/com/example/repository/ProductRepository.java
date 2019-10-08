package com.example.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.dto.Product;
import com.example.exceptions.ProductNotFoundExecption;

@Repository
public class ProductRepository {
	
	List<Product> pd=null;
	
	@PostConstruct
	public void initializer() {
		
	Product product=new Product();
	Product product1=new Product();
	Product product2=new Product();
	Product product3=new Product();
	
	product.setProductId(1001);
	product.setProductName("Dove");
	product.setProductInStock("Yes");
	product.setProductPrice(200.0);
	product.setProductVender("Willys");
	product.setProductCode(111);
	
	product1.setProductId(1002);
	product1.setProductName("Lorael Shampoo");
	product1.setProductInStock("Yes");
	product1.setProductPrice(500.0);
	product1.setProductVender("ICA");
	product1.setProductCode(222);
	
	product2.setProductId(1003);
	product2.setProductName("Dove");
	product2.setProductInStock("No");
	product2.setProductPrice(300.0);
	product2.setProductVender("Keviberg");
	product2.setProductCode(333);
	
	product3.setProductId(1004);
	product3.setProductName("Dove Soap");
	product3.setProductInStock("Yes");
	product3.setProductPrice(100.0);
	product3.setProductVender("Willys");
	product3.setProductCode(444);
	
	pd=new ArrayList<>();
	pd.add(product);
	pd.add(product1);
	pd.add(product2);
	pd.add(product3);
	
	}
      
	public void addProduct(Product product) {
		
		pd.add(product);
		
			
	}

	public List<Product> fetchprod() {
		
		return pd;
	}
	
	
	public void deleteProduct(Product product) {
		
		pd.remove(product);
		
	}
	
	
public List<Product> fetchproddetails(String productName,String productVender) {
		List<Product> prod=new ArrayList<>();
		for(Product pk:pd) {
			
			if(pk.getProductName().equals(productName)|| pk.getProductVender().equals(productVender))
			{
				prod.add(pk);
			}
		}
		return prod;
	}

public List<Product> getProducts(List ls) {

	List<Product> res=new ArrayList<>();
	Iterator it=ls.iterator();
	
	while(it.hasNext()) {
		
			
		String vender=(String) it.next();
		
		for(Product pt:pd) {
			
			if(vender.equals(pt.getProductVender()))
			{
				
				res.add(pt);
			}
			
			}
		}
	
	return res;
	}

public String deleteProductCode(long productCode) throws ProductNotFoundExecption{
	Boolean notfound=true;
	
	String res="Product of " +productCode + "\t does not exist";
	
	for(Product pt:pd)
	{
		if(pt.getProductCode()==productCode)
		{
			pd.remove(pt);
			res=pt.getProductCode() +"deleted Successfully";
			notfound=false;
			break;
		}
	}
	if(notfound) throw new ProductNotFoundExecption("product Does not exist: " +productCode);
	return res;
}
	
	
}
