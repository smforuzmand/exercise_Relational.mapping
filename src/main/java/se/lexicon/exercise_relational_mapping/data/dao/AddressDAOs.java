package se.lexicon.exercise_relational_mapping.data.dao;

import se.lexicon.exercise_relational_mapping.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDAOs {

    Address save(Address address);

    Optional<Address> findByAddressId(int id);

    List<Address> findAll();

    List<Address> findByZipCode(String zipCode);

    void delete(Address address);

    Address update(Address address);

}
