package Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private int houseNumber;
    @Column(nullable = false)
    private int apartNumber;
    @OneToMany(mappedBy = "address")
    private List<User> users = new ArrayList<>();
}
