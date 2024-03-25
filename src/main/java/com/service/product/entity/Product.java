package com.service.product.entity;

import com.service.product.Dto.ProductDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="tbl_product")
@Data

public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	private String name;
	
	private Long price;
	
	@Lob
	private String description;
	
	@Lob
	@Column(columnDefinition ="longblob")
	private byte[] img;
	
	private Long catId;
	
	public ProductDto getDto() {
		ProductDto productDto = new ProductDto();
		productDto.setId(id);
		productDto.setName(name);
		productDto.setPrice(price);
		productDto.setDescription(description);
		productDto.setImagename(img);
		productDto.setCatId(catId);
		return productDto;
	}
	
}
