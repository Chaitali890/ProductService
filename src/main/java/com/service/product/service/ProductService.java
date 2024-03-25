package com.service.product.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.service.product.Dto.ProductDto;
import com.service.product.entity.Product;

public interface ProductService {

	ProductDto addProduct(ProductDto productDto) throws IOException;
//	Product addToProduct(Product prod);
	List<Product> getAllProducts();
//	ProductDto getProductById(Long id);
	Product getProductById(Long id);
	List<Product> getProductByCatId(Long id);
}
