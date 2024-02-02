package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
//@interface NotNull {}

public class Validator{
    public static List<String> validate(Address address) {

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


            public static void main(String[] args) {
                Address example = new Address("Russia", null, "123 Street", "12", "147");

                List<String> invalidFields = Validator.validate(example);

                if (invalidFields.isEmpty()) {
                    System.out.println("Object is valid");
                } else {
                    System.out.println("Invalid fields: " + invalidFields);
                }
            }


}
