package org.example.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
    @ManyToOne(cascade = {CascadeType.PERSIST, })
    @JoinColumn(name = "address")
    private Address address;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "task")
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setTask(Task task){
        this.tasks.add(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        LocalDate age = LocalDate.now().minusYears(birthday.getYear()).minusMonths(birthday.getMonthValue()).minusDays(birthday.getDayOfMonth());
        return age.getYear();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" +this.getId() +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                ", tasks=" + tasks +
                '}';
    }
}
