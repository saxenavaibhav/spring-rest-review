package saxena.vaibhav.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import saxena.vaibhav.dto.UserDto;
import saxena.vaibhav.service.UserService;

@RestController
@RequestMapping(value = "api/user")
@AllArgsConstructor
@Tag(
		name = "CRUD REST APIs for User resource",
		description = "CRUD REST APIssuch as create, delete, update etc" 
	)
public class UserController {

    private UserService userService;

    @Operation(
    		summary = "Create User REST API",
    		description = "Create User REST API is used to save a User to the DB"
    		)
    @ApiResponse(
    		responseCode = "201",
    		description="HTTP status 201 CREATED"
    )
    @PostMapping("create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto userDto = userService.createUser(user);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
    }

    @Operation(
    		summary = "Get User by ID REST API",
    		description = "Get User REST by ID API is used to get a user based on the ID"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description="HTTP status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserByid(id), HttpStatus.OK);
    }

    @Operation(
    		summary = "Find All Users REST API",
    		description = "Find all Users REST API is used to find all users"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description="HTTP status 200 OK"
    )
    @GetMapping("findall")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Operation(
    		summary = "Update User REST API",
    		description = "Update User REST API is used to updated a User to the DB"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description="HTTP status 200 OK"
    )
    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") Long id,
                                           @RequestBody UserDto user) {
        user.setId(id);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);


    }

    @Operation(
    		summary = "Delete User REST API",
    		description = "Delete User REST API is used to Delete a user"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description="HTTP status 200 OK"
    )
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Successfully Deleted", HttpStatus.OK);
    }
    
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
//    																	WebRequest request) {
//    	ErrorDetails errorDetails = new ErrorDetails(
//    			LocalDateTime.now(),
//    			ex.getMessage(),
//    			request.getDescription(false),
//    			"USER_NOT_FOUND"
//    			);
//    	return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
