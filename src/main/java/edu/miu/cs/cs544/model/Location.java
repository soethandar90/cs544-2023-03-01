package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="locationId")
    private int locationId;

    @Column(name="locationName")
    private String locationName;

    @Column(name="description")
    private String description;

    @Column(name="locationType")
    private LocationType locationType;

    @Column(name="capacity")
    private int capacity;

    @OneToMany
    @JoinTable(name="location_timeslot",
            joinColumns = {@JoinColumn(name="locationId")},
            inverseJoinColumns = {@JoinColumn(name="timeslotId")})
    private List<Timeslot> timeSlots;
}
