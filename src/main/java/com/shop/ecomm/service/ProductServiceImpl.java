package com.shop.ecomm.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Category;
import com.shop.ecomm.model.Product;
import com.shop.ecomm.repository.CategoryRepository;
import com.shop.ecomm.repository.ProductRepository;
import com.shop.ecomm.repository.UserRepository;
import com.shop.ecomm.request.CreateProductRequest;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private UserRepository userRepository;
	private CategoryRepository categoryRepository;

	public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository,
			CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Product createProduct(CreateProductRequest req) {
		Category topLevel = categoryRepository.findByName(req.getTopLevelCategory());

		// topLevel
		if (topLevel == null) {
			Category topLevelCategory = new Category();
			topLevelCategory.setName(req.getTopLevelCategory());
			topLevelCategory.setLevel(1);

			topLevel = categoryRepository.save(topLevelCategory);
		}

		// secondLevel
		Category secondLevel = categoryRepository.findByNameAndParent(req.getSecondLevelCategory(), topLevel.getName());

		if (secondLevel == null) {

			Category secondLeveCategory = new Category();
			secondLeveCategory.setName(req.getSecondLevelCategory());
			secondLeveCategory.setParentCategory(topLevel);
			secondLeveCategory.setLevel(2);

			secondLevel = categoryRepository.save(secondLeveCategory);
		}

		// thirdLevel
		Category thirdLevel = categoryRepository.findByNameAndParent(req.getThirdLevelCategory(),
				secondLevel.getName());

		if (thirdLevel == null) {

			Category thirdLevelCategory = new Category();
			thirdLevelCategory.setName(req.getThirdLevelCategory());
			thirdLevelCategory.setParentCategory(secondLevel);
			thirdLevelCategory.setLevel(3);

			thirdLevel = categoryRepository.save(thirdLevelCategory);
		}

		Product product = new Product();
		product.setTitle(req.getTitle());
		product.setColor(req.getColor());
		product.setDescription(req.getDescription());
		product.setDiscountedPrice(req.getDiscountedPrice());
		product.setDiscountPersent(req.getDiscountPersent());
		product.setImageUrl(req.getImgagUrl());
		product.setBrand(req.getBrand());
		product.setPrice(req.getPrice());
		product.setSize(req.getSize());
		product.setQuantity(req.getQuantity());
		product.setCategory(thirdLevel);
		product.setCreatedAt(LocalDateTime.now());

		Product savedProduct = productRepository.save(product);

		return savedProduct;
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {

		Product product = findProductById(productId);
		product.getSize().clear();
		productRepository.delete(product);

		return "Product Deleted Successfully !";
	}

	@Override
	public Product updateproduct(Long productId, Product req) throws ProductException {

		Product product = findProductById(productId);
		if (req.getQuantity() != 0) {
			product.setQuantity(req.getQuantity());
		}

		return productRepository.save(product);
	}

	@Override
	public Product findProductById(Long Id) throws ProductException {
		Optional<Product> opt = productRepository.findById(Id);

		if (opt.isPresent()) {
			return opt.get();

		}
		throw new ProductException("Product not found with Id: " + Id);
	}

	@Override
	public List<Product> findProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> getAllProductByCategory(String category, List<String> sizes, List<String> colors,
			Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber,
			Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<Product> products = productRepository.filterProducts(category, minPrice, maxPrice, minDiscount, sort);

		// COlors Filteration Logic
		if (!colors.isEmpty()) {
			products = products.stream().filter(p -> colors.stream().anyMatch(c -> c.equalsIgnoreCase(p.getColor())))
					.collect(Collectors.toList());
		}
		return null;
	}

}
