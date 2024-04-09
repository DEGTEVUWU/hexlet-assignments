package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    // Из методов сервиса возвращаем типы Reactor Flux<T> или Mono<T>

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> show(Long userId) {
        return userRepository.findById(userId);
    }
    public Mono<User> update(User user, Long id) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                });
    }
    public Mono<Void> delete(Long userId) {
        return userRepository.deleteById(userId);
    }
    // END
}
