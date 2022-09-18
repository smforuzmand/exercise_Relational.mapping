package se.lexicon.exercise_relational_mapping.data.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.exercise_relational_mapping.entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class AddressDAOImpl implements AddressDAOs {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public Address save(Address address) {
        if (address == null) throw new IllegalArgumentException("address is empty");
        if (address.getAddressId() <= 0) {
            entityManager.persist(address);
            return address;
        } else {
            entityManager.merge(address);
        }

        return address;
    }

    @Override
    public Optional<Address> findByAddressId(int id) {

        return Optional.ofNullable(entityManager.find(Address.class, id));


    }

    @Transactional(readOnly = true)
    @Override
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a",
                Address.class).getResultList();

    }

    @Transactional(readOnly = true)
    @Override
    public List<Address> findByZipCode(String zipCode) {
        List<Address> foundMatch = new ArrayList<>();

        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.zipCode= :zc", Address.class);
        query.setParameter("zc", zipCode);
        foundMatch = query.getResultList();
        return foundMatch;


    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(Address address) {
        findByAddressId(address.getAddressId()).orElseThrow(() -> new IllegalArgumentException("OPEN EYES"));
        entityManager.remove(address);

    }

    @Override
    public Address update(Address address) {

        return entityManager.merge(address);
    }
}
