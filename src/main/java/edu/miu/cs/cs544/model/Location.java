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
    private int id;

    @Column(name="locationName")
    private String locationName;
    @Column(name="description")
    private String description;

    @Column(name="locationType ")
    private LocationType locationType;
    private int capacity;

    @OneToMany(mappedBy = "")
    @Column(name = "transactions")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "")
    @Column(name = "timeslots")
    private List<Timeslot> timeSlots;

    @ManyToOne
    @Column(name = "plan")
    private Plan plan;

}
