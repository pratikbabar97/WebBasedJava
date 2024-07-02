package com.blogs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.blogs.dtos.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.entities.Products;

public interface ProductService {

	List<Products> getAllProducts();
	Products addNewProducts(Products product);
	ApiResponse updateProducts(Long productId, Products product);
	ApiResponse deleteProduct(Long productId);
	//List<Products> findProductsBYCategory(Category category);
	List<Products> findProductsBYCategory(Category category);
	
}
