package se.lexicon.exercise_relational_mapping.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(length = 255, nullable = false, unique = true)
    private String email;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;


    @OneToMany(cascade = CascadeType.PERSIST , mappedBy = "owner")
    Collection<Car> ownedCars;



    public AppUser() {

    }
    public AppUser(int userId, String email, String name, String password, Address address) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public AppUser(String email, String name, String password, Address address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, name, password);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userId == appUser.userId && Objects.equals(email, appUser.email) && Objects.equals(name, appUser.name) && Objects.equals(password, appUser.password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
