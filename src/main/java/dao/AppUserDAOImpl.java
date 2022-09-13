package dao;

import entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.exercise_relational_mapping.EntityNotFoundException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Repository
public class AppUserDAOImpl implements AppUserDAOs {



    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public AppUser save(AppUser appUser) {

        if (appUser == null) throw new IllegalArgumentException("appUser is null");
        entityManager.persist(appUser);
        return appUser;
    }

    @Transactional
    @Override
    public Optional<AppUser> findById(int id) {
if (id<=0) throw new IllegalArgumentException("Invalid Id");
        AppUser user=entityManager.find(AppUser.class, id);
        return Optional.ofNullable(user);
    }

    @Transactional
    @Override
    public List<AppUser> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM AppUser a");

        return query.getResultList();
    }

    @Transactional
    @Override
    public void remove(AppUser appUser) {
        findById(appUser.getUserId()).orElseThrow(() -> new EntityNotFoundException("data not found"));

    }

    @Transactional
    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Transactional
    @Override
    public List<AppUser> saveAppUsers(List<AppUser> appUsers) {
        return null;
    }
}
