package se.lexicon.exercise_relational_mapping.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.exercise_relational_mapping.entity.Address;
import se.lexicon.exercise_relational_mapping.entity.AppUser;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    /**
     * a. Find an AppUser with matching email.
     * b. Find an AppUser with matching email and password.
     * c. Find AppUser’s by name containing specified String.
     * d. Find AppUser’s that live on the same address.
     * e. Find AppUser’s that live in the same city.
     */


    //a. Find an AppUser with matching email.
    List<AppUser> findAppUsersByEmailIgnoreCase(String email);


    //b. Find an AppUser with matching email and password.
    List<AppUser> findAppUsersByEmailAndPassword(String email, String password);

    //c. Find AppUser’s by name containing specified String.
    @Query("SELECT a FROM AppUser a WHERE a.name = :n")
    List<AppUser> findAppUsersByNameContaining(@Param("n") String name);

    //d. Find AppUser’s that live on the same address.
    @Query("SELECT a FROM AppUser a WHERE a.address = :adre")
    List<AppUser> findAppUsersByAddress(@Param("adre") Address address);

    //e. Find AppUser’s that live in the same city.
    @Query("SELECT a FROM AppUser a WHERE a.address.city = :c")
    List<AppUser> findAppUsersByAddress_City(@Param("c") String city);


}
