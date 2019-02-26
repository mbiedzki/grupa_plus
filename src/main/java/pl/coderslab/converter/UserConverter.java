package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

public class UserConverter implements Converter<String, User> {
    @Autowired
    private UserService userService;

    @Override
    public User convert(String s) {
        return userService.findOne(Long.parseLong(s));
    }
}
