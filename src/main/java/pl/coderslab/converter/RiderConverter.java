package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Rider;
import pl.coderslab.service.RiderService;

public class RiderConverter implements Converter<String, Rider> {
    @Autowired
    private RiderService riderService;

    @Override
    public Rider convert(String s) {
        return riderService.findOne(Long.parseLong(s));
    }
}
