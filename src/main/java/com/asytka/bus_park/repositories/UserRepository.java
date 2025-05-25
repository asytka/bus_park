package com.asytka.bus_park.repositories;

import com.asytka.bus_park.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
