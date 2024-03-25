package com.service.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.product.Dto.ProductDto;
import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import com.service.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductService {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
//	@Test
//	public void createProduct() throws IOException {
//		Product product = new Product();
//		product.setId(1L);
//		product.setName("saree");
//		product.setPrice(100L);
//		product.setDescription("This is saree section");
//		product.setCatId(3L);
//		Mockito.when(productRepository.save(product)).thenReturn(product);
//		assertThat(productService.addToProduct(product)).isEqualTo(product);		
//	}
	
	
	
	
	
	
//	
//	@Test
//	public void getAllProduct() {
//		Product product = new Product();
//		product.setId(1L);
//		product.setName("saree");
//		product.setPrice(100L);
//		product.setDescription("This is saree section");
//		product.setCatId(3L);
//		
//		Product product1 = new Product();
//		product1.setId(2L);
//		product1.setName("kurta");
//		product1.setPrice(100L);
//		product1.setDescription("This is kurta section");
//		product1.setCatId(4L);
//		
//		List<Product> list = new ArrayList<>();
//			list.add(product);
//			list.add(product1);
//		Mockito.when(productRepository.findAll()).thenReturn(list);
//		assertThat(productService.getAllProducts()).isEqualTo(list);
//	}
//	
	@Test
	public void getProductById() {
		Long id = 1L;
		
		Product mockProduct = Mockito.mock(Product.class);
		when(productRepository.findById(id)).thenReturn(Optional.of(mockProduct));
		
		Product result = productService.getProductById(id);
	}
	
	@Test
	public void getProductByCatId() {
		Long id = 3L;
		List<Product> mockList = new ArrayList<>();
		Product mockProduct = Mockito.mock(Product.class);
		mockList.add(mockProduct);
		when(productRepository.findByCatId(id)).thenReturn(mockList);
	}
}
