package com.shop.ecomm.service;

import java.util.List;

import org.springframework.data.domain.Page;
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
		return null;
	}

	@Override
	public Product deleteProduct(Long productId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateproduct(Long productId, Product product) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(Long Id) throws ProductException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
