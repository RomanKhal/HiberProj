package org.example.Entities;

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

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Address(){
        super();
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setApartNumber(int apartNumber) {
        this.apartNumber = apartNumber;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartNumber() {
        return apartNumber;
    }

    public List<User> getUsers() {
        return users;
    }

//    @Override
//    public String toString() {
//        return "Address{" +
//                "id=" + id +
//                ", city='" + city + '\'' +
//                ", street='" + street + '\'' +
//                ", houseNumber=" + houseNumber +
//                ", apartNumber=" + apartNumber +
//                ", users=" + users +
//                '}';
//    }
}
