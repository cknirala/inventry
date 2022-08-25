package com.example.springbootproject.service;

import com.example.springbootproject.entity.Product;
import com.example.springbootproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;
  //POST method
  public Product saveProduct(Product product){
    return repository.save(product);
  }
  public List<Product> saveProducts(List<Product> products){
    return repository.saveAll(products);
  }
  //GET method
  public List<Product> getProducts(){
    return repository.findAll();
  }

  public Product getProductByName(String name){

    return repository.findByName(name);
  }
  //DELETE method
  public String deleteProduct(int id){
    repository.deleteById(id);
    return "Product removed!!" +id;
  }
  //UPDATE method
  public Product updateProduct(Product product){
    Product existingProduct=repository.findById(product.getId()).orElse(null);
    existingProduct.setName(product.getName());
    existingProduct.setQuantity(product.getQuantity());
    existingProduct.setPrice(product.getPrice());
    return repository.save(existingProduct);
  }

}
