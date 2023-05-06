package saxena.vaibhav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import saxena.vaibhav.dto.UserDto;

@Service
public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserByid(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long id);
}
