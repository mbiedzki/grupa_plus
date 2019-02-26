package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Product;
import pl.coderslab.model.Rider;
import pl.coderslab.service.ProductService;

public class ProductConverter implements Converter<String, Product> {
    @Autowired
    private ProductService productService;

    @Override
    public Product convert(String s) {
        return productService.findOne(Long.parseLong(s));
    }
}
