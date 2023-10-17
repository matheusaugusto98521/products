package br.com.api.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.products.model.ModelProduct;

@Repository
public interface ProductRepository extends CrudRepository<ModelProduct, Long>{
    
}
