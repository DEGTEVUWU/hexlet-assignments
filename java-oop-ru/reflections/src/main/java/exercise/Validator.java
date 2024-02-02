package exercise;

import java.lang.reflect.Field;
import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.List;
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
//@interface NotNull {}

public class Validator{
    public static List<String> validate(Object address) {
        List<String> invalidFields = new ArrayList<>();

        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return invalidFields;
    }
    public static Map<String, List<String>> advancedValidate(Object address) {
        List<Field> fields = List.of(address.getClass().getDeclaredFields());
        Map<String, List<String>> validationErrors = new HashMap<>();

        fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(MinLength.class))
                .forEach(field -> {
                    String fieldName = field.getName();
                    List<String> errors = getErrorsForField(field, address);
                    if (!errors.isEmpty()) {
                        validationErrors.put(fieldName, errors);
                    }
                });
        return validationErrors;
    }
    public static List<String> getErrorsForField(Field field, Object address) {
        List<String> errors = new ArrayList<>();
        String value;

        try {
            field.setAccessible(true);
            value = (String) field.get(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            errors.add("can not be null");
        }

        if (field.isAnnotationPresent(MinLength.class)) {
            int minLength = field.getAnnotation(MinLength.class).minLength();
            if (value == null || value.length() < minLength) {
                errors.add("length less than " + minLength);
            }
        }
        return errors;
    }
    public static void main(String[] args) {
        Address example = new Address(null, null, "123 Street", "12", "147");

        List<String> invalidFields = Validator.validate(example);

        System.out.println(invalidFields);

        Map<String, List<String>> resultMap = advancedValidate(example);

        System.out.println(resultMap);
    }
}
