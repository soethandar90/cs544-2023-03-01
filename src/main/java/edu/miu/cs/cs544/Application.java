package edu.miu.cs.cs544;

import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Role role=new Role("Student",);
//		Member member=new Member("Bob","Frank","bob.frank@gmail.com".);
//	}
}
