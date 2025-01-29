package org.example.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    AddressDetails addressDetails;
    @OneToMany(mappedBy = "address")
    private List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String city, String street, int houseNumber, int apartNumber) {
        this.addressDetails = new AddressDetails(city, street, houseNumber, apartNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressDetails=" + addressDetails +
                '}';
    }

    @Embeddable
     static class AddressDetails {
        @Basic(optional = false)
        private String city;
        @Basic(optional = false)
        private String street;
        @Basic(optional = false)
        private int houseNumber;
        @Basic(optional = false)
        private int apartNumber;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
        }

        public int getApartNumber() {
            return apartNumber;
        }

        public void setApartNumber(int apartNumber) {
            this.apartNumber = apartNumber;
        }

        AddressDetails(){}

        AddressDetails(String city, String street, int houseNumber, int apartNumber) {
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
            this.apartNumber = apartNumber;
        }

        @Override
        public String toString() {
            return "AddressDetails{" +
                    "city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", houseNumber=" + houseNumber +
                    ", apartNumber=" + apartNumber +
                    '}';
        }
    }
}
