package se.lexicon.exercise_relational_mapping.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.exercise_relational_mapping.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {


    //    a. Find a Car that match registration number.
    List<Car> findCarByRegNumber(int regNumber);


    //   b. Find all Car’s with a specific status code.
    @Query("SELECT c FROM Car c WHERE c.statusCode = :sc ")
    List<Car> findAllByStatusCode(@Param("sc") String sc);

    //    c. Find all Car’s older than a specific date.
    @Query("SELECT c FROM Car c WHERE c.regDate > :sdate")
    List<Car> findAllByRegDateAfter(@Param("sdate") LocalDate specificDate);

    //    d. Find all Car’s newer than a specific date.
    @Query("SELECT c FROM Car c WHERE c.regDate < :sdate")
    List<Car> findAllByRegDateBefore(@Param("sdate") LocalDate specificDate);

    //    e. Find all Car’s registered between two dates.
    @Query("SELECT c FROM Car c WHERE c.regDate BETWEEN :startDate AND :endDate")
    List<Car> findAllByRegDateBetween(@Param("startDate") LocalDate start, @Param("endDate") LocalDate end);


}
