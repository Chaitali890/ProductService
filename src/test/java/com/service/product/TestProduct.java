package com.service.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.service.product.Dto.ProductDto;
import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import com.service.product.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class TestProduct {

	@InjectMocks
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	public void addProduct() throws IOException {
		ProductDto productDto = new ProductDto();
		productDto.setId(3L);
		productDto.setName("saree");
		productDto.setPrice(200L);
		productDto.setDescription("This is saree section");
		productDto.setCatId(3L);
		
		Product product = new Product();
		product.setId(3L);
		product.setName("saree");
		product.setPrice(200L);
		product.setDescription("This is saree section");
		product.setCatId(3L);
		
		
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
		assertThat(productService.addProduct(productDto)).isEqualTo(product);		

	}
	
	
}
