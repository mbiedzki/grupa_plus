package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.MainCover;
import pl.coderslab.service.MainCoverService;

public class MainCoverConverter implements Converter<String, MainCover> {
    @Autowired
    private MainCoverService mainCoverService;

    @Override
    public MainCover convert(String s) {
        return mainCoverService.findOne(Long.parseLong(s));
    }
}
