package com.ecom.shopsphere.repository;

import com.ecom.shopsphere.entity.RefreshToken;
import com.ecom.shopsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Ref;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    Optional<RefreshToken> findByUser(User user);

    void deleteByUser(User user);

    void deleteByRefreshToken(String refreshToken);

    boolean existsByRefreshToken(String refreshToken);

}