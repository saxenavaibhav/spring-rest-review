package saxena.vaibhav;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info (
				title = "Spring Boot REST API Documentation",
				description="Spring Boot REST API Documentation",
				version ="v1.0",
				contact = @Contact (
						name = "Vaibhav Saxena",
						email="reachvaibhavsaxena@gmail.com"
						),
				license=@License(
						name = "Apache 2.0")
				)
		)
public class SpringbootRestApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

}
