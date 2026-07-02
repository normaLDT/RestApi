package com.landeta.restapi.controllers;

import com.landeta.restapi.controllers.dto.ProductDTO;
import com.landeta.restapi.entities.Product;
import com.landeta.restapi.persistence.IProductDAO;
import com.landeta.restapi.services.IProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductDAO iProductDAO;

    @GetMapping("/find/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> optionalProduct = productService.findById(id);

        if(optionalProduct.isPresent()){

            Product product = optionalProduct.get();

            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();

            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    private ResponseEntity<?> findAll(){
        List<ProductDTO> produtList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build()
                ).toList();
        return ResponseEntity.ok(produtList);

    }

    @PostMapping("/save")
    private ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {

        if(productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null){
            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
                        .name(productDTO.getName())
                        .price(productDTO.getPrice())
                        .maker(productDTO.getMaker())
                        .build();

        productService.save(product);

        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO){

        Optional<Product> productOptional = productService.findById(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();

            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());

            productService.save(product);

            return ResponseEntity.ok("Actualizacion correcta");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){

        if(id != null){
            productService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado...");
        }
        return ResponseEntity.badRequest().build();
    }
}
