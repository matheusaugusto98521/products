package br.com.api.products.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.model.ModelProduct;
import br.com.api.products.model.ResponseModel;
import br.com.api.products.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductControl {
 
    @Autowired
    private ProductService ps;

    @DeleteMapping("/remove/{code}")
    public ResponseEntity<ResponseModel> remove(@PathVariable Long code){
        return ps.remove(code);
    }

    @PutMapping("/alterate")
    public ResponseEntity<?> alterate(@RequestBody ModelProduct pm){
        return ps.registrationAlterate(pm, "alterate");
    }


    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody ModelProduct pm){
        return ps.registrationAlterate(pm, "registration");
    }

    @GetMapping("/list")
    public Iterable<ModelProduct> lists(){
        return ps.list();
    }
    
    @GetMapping("/")
    public String route(){
        return "working product API";
    }

}
