package saxena.vaibhav.mapper;

import saxena.vaibhav.dto.UserDto;
import saxena.vaibhav.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto (
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return dto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User (
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
