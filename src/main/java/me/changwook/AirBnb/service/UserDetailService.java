package me.changwook.AirBnb.service;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.User;
import me.changwook.AirBnb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private static final Logger logger =  LoggerFactory.getLogger(UserDetailService.class);

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> {
            logger.error("사용자{}를 찾을 수 없습니다.", email);
            return new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        });
    }
}
