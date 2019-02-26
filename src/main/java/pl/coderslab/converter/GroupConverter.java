package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Group;
import pl.coderslab.service.GroupService;

public class GroupConverter implements Converter<String, Group> {
    @Autowired
    private GroupService groupService;

    @Override
    public Group convert(String s) {
        return groupService.findOne(Long.parseLong(s));
    }
}