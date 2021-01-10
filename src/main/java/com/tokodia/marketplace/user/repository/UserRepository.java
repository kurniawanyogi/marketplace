package com.tokodia.marketplace.user.repository;

import com.tokodia.marketplace.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findUserByEmailAndPhone(String email, String phone);
}
