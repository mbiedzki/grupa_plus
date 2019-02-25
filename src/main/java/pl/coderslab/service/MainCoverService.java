package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.MainCover;
import pl.coderslab.model.Product;
import pl.coderslab.repository.MainCoverRepository;
import pl.coderslab.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class MainCoverService {
    @Autowired
    private MainCoverRepository mainCoverRepository;
    @Autowired
    private ProductRepository productRepository;

    public void save(MainCover mainCover) {
        mainCoverRepository.save(mainCover);
    }

    public void delete(Long id) {
        mainCoverRepository.delete(id);
    }

    public MainCover findOne(Long id) {
        return mainCoverRepository.findOne(id);
    }

    public List<MainCover> findAll() {
        return mainCoverRepository.findAll();
    }

    public boolean noProductsWithMainCoverId(Long id) {
        List<Product> products = productRepository.findProductByMainCoverId(id);
        if (!products.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
