package Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Transient
    private int age;
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
//    @OneToMany
//    private List<User> children;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
