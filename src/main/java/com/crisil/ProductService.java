package com.crisil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<ProductEntities> listAll() {
		return repo.findAll();
	}
	
	public void Save(ProductEntities productEntities) {
		repo.save(productEntities);
	}
	
	public ProductEntities get(Integer id){
		return repo.findById(id).get();
	}
	
	public void delete(Integer id){
		repo.deleteById(id);
	}

	public void saveAll(List<ProductEntities> productEntities) {
		repo.saveAll(productEntities);
		
	}
}
