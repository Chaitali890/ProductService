package com.service.product.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.product.Dto.ProductDto;
import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	public ProductDto addProduct(ProductDto productDto) throws IOException
	{
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		product.setImg(productDto.getImg().getBytes());
		product.setCatId(productDto.getCatId());
		return productRepository.save(product).getDto();
	}
	
//	public Product addToProduct(Product prod) {
//		return productRepository.save(prod);
//	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
//	public ProductDto getProductById(Long id) {
//		Optional<Product> optionalProduct = productRepository.findById(id);
//		if(optionalProduct.isPresent()) {
//			return optionalProduct.get().getDto();
//		}
//		else
//		{
//			return null;
//		}
//	}
	
	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Product> getProductByCatId(Long id) {
		return productRepository.findByCatId(id);
		
	}
}
