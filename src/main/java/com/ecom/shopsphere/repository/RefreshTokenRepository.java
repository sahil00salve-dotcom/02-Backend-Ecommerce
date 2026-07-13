package com.ecom.shopsphere.repository;

import com.ecom.shopsphere.entity.RefreshToken;
<<<<<<< HEAD
import com.ecom.shopsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

        Optional<RefreshToken> findByToken(String token);

        Optional<RefreshToken> findByUser(User user);


        void deleteByUser(User user);

        void deleteByToken(String token);

        boolean existsByToken(String token);

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
>>>>>>> 9665014f809a43778d5b991f374791091a14099c
}
