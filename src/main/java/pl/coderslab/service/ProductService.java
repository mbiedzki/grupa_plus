package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Product;
import pl.coderslab.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }

    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    public List<Product> findAll() { return productRepository.findAll(); }
}
