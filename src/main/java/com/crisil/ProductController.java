package com.crisil;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<ProductEntities> list(){
		return service.listAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductEntities> get(@PathVariable Integer id) {
		try {
			ProductEntities productEntities = service.get(id);
			return new ResponseEntity<ProductEntities>(productEntities, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<ProductEntities>(HttpStatus.NOT_FOUND);
		}
		 
	}
	
	@PostMapping("/products")
	public void add(@RequestBody List<ProductEntities> productEntities) {
		service.saveAll(productEntities);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody ProductEntities productEntities, @PathVariable Integer id) {
		try {
			ProductEntities existProduct = service.get(id);
			service.Save(productEntities);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			ProductEntities existProduct = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
