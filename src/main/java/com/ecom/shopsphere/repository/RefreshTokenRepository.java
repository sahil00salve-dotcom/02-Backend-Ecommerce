package com.ecom.shopsphere.repository;

import com.ecom.shopsphere.entity.RefreshToken;
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


}