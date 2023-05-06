package saxena.vaibhav.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor 
@Schema(
		description = "User DTO Modelinformation"
		)

public class UserDto {
    
	private Long id;

	@Schema(
			description = "User First name"
			)
	@NotEmpty(message = "User First name should not be null or empty!")
	private String firstName;
    
	@Schema(
			description = "User Last name"
			)
	@NotEmpty(message = "User Last name should not be null or empty!")
	private String lastName;
    
	@Schema(
			description = "User Email address"
			)
	@NotEmpty(message = "User Email should not be null or empty!")
	@Email(message = "User email should be valid!")
	private  String email;
}
