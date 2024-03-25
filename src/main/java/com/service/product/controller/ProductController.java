package com.service.product.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.product.Dto.ProductDto;
import com.service.product.entity.Product;
import com.service.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException{
		ProductDto productDto1 = productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
	}
	
//	@PostMapping
//	public ResponseEntity<Product> addProduct(@ModelAttribute Product prod) throws IOException{
//		Product productDto1 = productService.addToProduct(prod);
//		return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
//	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
//		ProductDto productDto = productService.getProductById(id);
//			if(productDto!=null) {
//				return ResponseEntity.ok(productDto);
//			}else {
//				return ResponseEntity.notFound().build();
//			}
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product product = productService.getProductById(id);
			if(product!=null) {
				return ResponseEntity.ok(product);
			}else {
				return ResponseEntity.notFound().build();
			}
	}
	
	@GetMapping("/category/{id}")
	public List<Product> getProductByCatId(@PathVariable Long id) {
		return productService.getProductByCatId(id);
	}
}
