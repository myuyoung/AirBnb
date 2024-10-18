package me.changwook.AirBnb.service;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.User;
import me.changwook.AirBnb.dto.AddUserRequest;
import me.changwook.AirBnb.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder().email(dto.getEmail()).password(dto.getPassword()).build()).getId();
    }
}
