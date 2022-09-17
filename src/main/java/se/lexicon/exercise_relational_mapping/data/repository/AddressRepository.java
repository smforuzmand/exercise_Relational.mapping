package se.lexicon.exercise_relational_mapping.data.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.exercise_relational_mapping.entity.Address;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
