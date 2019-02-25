package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Product;
import pl.coderslab.model.Rider;
import pl.coderslab.repository.ProductRepository;
import pl.coderslab.repository.RiderRepository;

import java.util.List;

@Service
@Transactional
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private ProductRepository productRepository;

    public void save(Rider rider) {
        riderRepository.save(rider);
    }

    public void delete(Long id) {
        riderRepository.delete(id);
    }

    public Rider findOne(Long id) {
        return riderRepository.findOne(id);
    }

    public List<Rider> findAll() {
        return riderRepository.findAll();
    }

    public boolean noProductsWithRiderId(Long id) {
        List<Product> products = productRepository.findProductByRidersId(id);
        if (!products.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
