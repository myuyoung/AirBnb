package me.changwook.AirBnb.service;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.RefreshToken;
import me.changwook.AirBnb.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }
}
