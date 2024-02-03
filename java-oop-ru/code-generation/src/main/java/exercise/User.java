package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Getter
@NoArgsConstructor
@AllArgsConstructor
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
