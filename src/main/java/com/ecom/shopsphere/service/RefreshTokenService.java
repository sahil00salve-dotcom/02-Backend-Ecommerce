package com.ecom.shopsphere.service;

import com.ecom.shopsphere.entity.RefreshToken;
import com.ecom.shopsphere.entity.User;
import com.ecom.shopsphere.repository.RefreshTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public RefreshToken createRefreshToken(User user) {

        RefreshToken refreshToken = refreshTokenRepository.findByUser(user)
                .orElse(new RefreshToken());

        refreshToken.setUser(user);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(LocalDateTime.now().plusDays(7));

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken findByToken(String token) {


        return refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> {
                    return new RuntimeException("Refresh token not found");
                });
    }

    public Optional<RefreshToken> findByUser(User user) {

        return refreshTokenRepository.findByUser(user);
    }

    public void deleteByUser(User user) {


        refreshTokenRepository.deleteByUser(user);


    }

    public boolean existsByToken(String token) {


        return refreshTokenRepository.existsByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken refreshToken) {


        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {

            refreshTokenRepository.delete(refreshToken);

            throw new RuntimeException("Refresh token has expired. Please login again.");
        }

        return refreshToken;

    }

    public void deleteByToken(String token) {


        refreshTokenRepository.deleteByToken(token);


    }
}
