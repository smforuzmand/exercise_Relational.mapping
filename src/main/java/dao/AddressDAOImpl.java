package dao;

import entity.Address;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Component
public class AddressDAOImpl implements AddressDAOs{


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Optional<Address> findByAddressId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public List<Address> findByZipCode(String zipCode) {
        return null;
    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public Address update(Address address) {
        return null;
    }
}
