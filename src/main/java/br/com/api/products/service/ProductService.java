package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.model.ModelProduct;
import br.com.api.products.model.ResponseModel;
import br.com.api.products.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository pr;

    @Autowired
    private ResponseModel rm;

    //método para listar produtos
    public Iterable<ModelProduct> list(){
        return pr.findAll();
    }

    //método para registrar ou alterar produtos
    public ResponseEntity<?> registrationAlterate(ModelProduct pm, String action){

        if(pm.getName().equals("")){
            rm.setMessage("Product name is mandatory");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        else if(pm.getBrand().equals("")){
            rm.setMessage("Brand name is mandatory");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        else{
            if(action.equals("registration")){
                return new ResponseEntity<ModelProduct>(pr.save(pm), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<ModelProduct>(pr.save(pm), HttpStatus.OK);

            }
        }

    }

    //método para remover produtos
    public ResponseEntity<ResponseModel> remove(Long code){
        pr.deleteById(code);
        rm.setMessage("The product was removed successfully");

        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
