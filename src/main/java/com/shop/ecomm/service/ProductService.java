package com.shop.ecomm.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Product;
import com.shop.ecomm.request.CreateProductRequest;

public interface ProductService {

	public Product createProduct(CreateProductRequest req);

	public String deleteProduct(Long productId) throws ProductException;

	public Product updateproduct(Long productId, Product req) throws ProductException;

	public Product findProductById(Long Id) throws ProductException;

	public List<Product> findProductByCategory(String category);

	public Page<Product> getAllProductByCategory(String category, List<String> sizes, List<String> colors,
			Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber,
			Integer pageSize);
	// sort -> low to high
	// stock - > inStosk or outStock
	// pageSize , pageNumber -> pagination

}
