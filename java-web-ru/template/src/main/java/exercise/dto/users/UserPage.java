package exercise.dto.users;

import exercise.model.User;


import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class UserPage {
    public User user;
    public String description;
    public UserPage(User user, String description) {
        this.description = description;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }
}
