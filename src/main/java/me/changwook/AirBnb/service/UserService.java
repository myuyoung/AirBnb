package me.changwook.AirBnb.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.User;
import me.changwook.AirBnb.dto.AddUserRequest;
import me.changwook.AirBnb.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder().email(dto.getEmail()).password(bCryptPasswordEncoder.encode(dto.getPassword())).address(dto.getAddress()).build()).getId();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new IllegalArgumentException("Unexpected user"));
    }

    public  User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
