package com.course.api.booksapi.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<AuthoritiesEntity, Integer> {

    UserEntity findByUserEntity(UserEntity userEntity);
}
