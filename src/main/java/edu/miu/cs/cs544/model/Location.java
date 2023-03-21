package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Location")
@Validated
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="locationId")
    private int locationId;

    @Column(name="locationName")
    @NotNull
    private String locationName;

    @Column(name="description")
    @NotNull
    private String description;

    @Column(name="locationType",columnDefinition = "varchar(20)")
    @NotNull
    private LocationType locationType;

    @Column(name="capacity")
    @NotNull
    @Min(20)
    @Max(101)
    private int capacity;

//    @OneToMany
//    @JoinTable(name="location_timeslot",
//            joinColumns = {@JoinColumn(name="locationId")},
//            inverseJoinColumns = {@JoinColumn(name="timeslotId")})
//    private List<Timeslot> timeSlots;

//    @ManyToOne()
//    private Plan plan;
}
