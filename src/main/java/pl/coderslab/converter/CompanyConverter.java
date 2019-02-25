package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Company;
import pl.coderslab.service.CompanyService;

public class CompanyConverter implements Converter<String, Company> {
    @Autowired
    private CompanyService companyService;

    @Override
    public Company convert(String s) {
        return companyService.findOne(Long.parseLong(s));
    }
}
