package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class UsersPage {
    private List<User> users;
    private String header;

    public UsersPage(List<User> users, String header) {
        this.users = users;
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public List<User> getUsers() {
        return users;
    }
}
