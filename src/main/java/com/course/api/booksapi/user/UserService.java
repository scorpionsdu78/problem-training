package com.course.api.booksapi.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {

    private User user = null;

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;

    public UserService(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    public User getUserByUsername(String username) {

        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity != null ) {
            return createUserFromEntity(userEntity);
        } else {
            return null;
        }
    }

    private User createUserFromEntity(UserEntity userEntity) {
        User user = new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnabled());
        user.setAuthorities(userEntity.getAuthoritiesEntities().stream()
                .map(authoritiesEntity -> new SimpleGrantedAuthority(authoritiesEntity.getAuthority()))
                .collect(Collectors.toSet()));
        return user;
    }
}