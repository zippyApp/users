package com.zippy.users.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zippy.users.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
    User findUserById(Long id);
}
