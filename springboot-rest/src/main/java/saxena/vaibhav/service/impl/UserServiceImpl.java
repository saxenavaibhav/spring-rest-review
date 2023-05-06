package saxena.vaibhav.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saxena.vaibhav.dto.UserDto;
import saxena.vaibhav.entity.User;
import saxena.vaibhav.exception.EmailAlreadyExistsException;
import saxena.vaibhav.exception.ResourceNotFoundException;
import saxena.vaibhav.repository.UserRepository;
import saxena.vaibhav.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;
    
	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
    	Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
    	if (optionalUser.isPresent()) {
    		throw new EmailAlreadyExistsException("Email Already Exists!");
    	}
        //User userEntity = UserMapper.mapToUser(user);
    	User userEntity = modelMapper.map(user, User.class);

        User savedUser = userRepository.save(userEntity);
        //return UserMapper.mapToUserDto(savedUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserByid(Long id) {
        User user =  userRepository.findById(id).orElseThrow(
        		() -> new ResourceNotFoundException("User", "id", id)
        		);
        //return UserMapper.mapToUserDto(optionalUser.get());
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
         List<User> users = userRepository.findAll();
         //return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
         return users.stream().map((user) -> modelMapper.map(users, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser =  userRepository.findById(user.getId()).orElseThrow(
        		() -> new ResourceNotFoundException("User", "id", user.getId()));
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
    	User existingUser =  userRepository.findById(id).orElseThrow(
        		() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }


}
