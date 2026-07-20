package com.ecom.shopsphere.service;

import com.ecom.shopsphere.dto.request.RefreshTokenRequestDto;
import com.ecom.shopsphere.dto.response.RefreshTokenResponseDto;
import com.ecom.shopsphere.entity.RefreshToken;
import com.ecom.shopsphere.entity.User;
import com.ecom.shopsphere.repository.RefreshTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(LocalDateTime.now().plusDays(7));

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken findByToken(String refreshToken) {


        return refreshTokenRepository.findByRefreshToken(refreshToken)
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

    public boolean existsByToken(String refreshToken) {

        return refreshTokenRepository.existsByRefreshToken(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken refreshToken) {


        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {

            refreshTokenRepository.delete(refreshToken);

            throw new RuntimeException("Refresh token has expired. Please login again.");
        }

        return refreshToken;

    }

    @Transactional
    public void deleteByToken(String token) {

        RefreshToken refreshToken = refreshTokenRepository
                .findByRefreshToken(token)
                .orElseThrow(() -> new RuntimeException("Refresh token not found"));

        User user = refreshToken.getUser();

        if (user != null) {
            user.setRefreshToken(null);
        }

        refreshTokenRepository.delete(refreshToken);
    }


}
