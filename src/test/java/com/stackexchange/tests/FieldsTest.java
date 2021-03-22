package com.stackexchange.tests;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class FieldsTest {

    @SneakyThrows(IllegalAccessException.class)
    public Boolean objectHasProperty(Object obj, String fieldName){
        List<Field> fields = Arrays.asList(obj.getClass().getDeclaredFields());
        for(Field field : fields){
            if(field.getName().endsWith(fieldName) & field.get(obj) != null){
                return true;
            }
        }
        return false;
    }
}
