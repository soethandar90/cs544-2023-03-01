package edu.miu.cs.cs544;

import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(name="modelMapper")
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Role role=new Role("Student",);
//		Member member=new Member("Bob","Frank","bob.frank@gmail.com".);
//	}
}
