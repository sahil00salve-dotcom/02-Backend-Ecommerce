package com.ecom.shopsphere.repository;

import com.ecom.shopsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);
    Optional<User>deleteByEmail(String email);
=======
@Repository
public interface UserRepository extends JpaRepository<User , Long> {
>>>>>>> 9665014f809a43778d5b991f374791091a14099c
}
