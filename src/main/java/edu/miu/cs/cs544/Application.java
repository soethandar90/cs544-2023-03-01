package edu.miu.cs.cs544;

import edu.miu.cs.cs544.dto.Day;
import edu.miu.cs.cs544.dto.LocationType;
import edu.miu.cs.cs544.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;

import java.time.LocalTime;

@SpringBootApplication
public class Application {//implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    Location location = new Location("R0", "Place u eat food", LocationType.DINING_HALL, 50);
//    Timeslot timeslot = new Timeslot(LocalTime.of(2, 3, 5), LocalTime.of(1, 3, 5), Day.FRIDAY, location);
//    Plan plan=new Plan("MealPlan","This is meal Plan",);

//    Location location = new Location(1,"R0", "Place u eat food", LocationType.DINING_HALL, 50);
//    Timeslot timeslot = new Timeslot(1,LocalTime.of(12,30,30), LocalTime.of(8, 3, 5), Day.MONDAY, 1);
//    Timeslot timeslot1 = new Timeslot(2,Time.of(2, 3, 5), Time.of(1, 3, 5), Day.FRIDAY, 1);

}
