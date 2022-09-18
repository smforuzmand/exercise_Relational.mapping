package se.lexicon.exercise_relational_mapping.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.exercise_relational_mapping.entity.Address;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Integer> {
    //Find all addresses in a specified city.

    @Query("SELECT a FROM Address a WHERE a.city = :cn")
    List<Address> findAllByCity(@Param("cn") String city);







}
