package com.service.product.Dto;

import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ProductDto {

	private Long id;
	
	private String name;
	
	private Long price;
	
	private String description;
	
	private byte[] imagename;
	
	private MultipartFile img;
	
	private Long catId;
	
}
