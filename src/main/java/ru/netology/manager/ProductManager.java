package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product){
        repository.save(product);
    }

    public Product[] findAll() {
        return repository.getAll();
    }

    public Product findById(int id){
        return repository.findById(id);
    }

    public void removeById(int id){
        repository.removeById(id);
    }





}
