package com.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Category;
import com.blogs.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{

	List<Products> findByCategoryContaining(Category category);

}