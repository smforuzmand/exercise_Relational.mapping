package se.lexicon.exercise_relational_mapping.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Status {

    @Id
    @GeneratedValue
    private int statusId;

    @Column(length = 255, nullable = false)
    private String statusCode;

    @Column
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "car_status", joinColumns = @JoinColumn(name = "status_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Collection<Car> cars = new ArrayList<>();


    public void addCars(Car car) {

        if (!cars.contains(car)) {
            cars.add(car);
        }
    }


    public void removeCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
    }

    public Status(String statusCode, Collection<Car> cars) {
        this.statusCode = statusCode;
        this.cars = cars;
    }

    public Status() {
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusCode='" + statusCode + '\'' +
                ", cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return statusId == status.statusId && Objects.equals(statusCode, status.statusCode) && Objects.equals(cars, status.cars);


    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusCode, cars);
    }
}
