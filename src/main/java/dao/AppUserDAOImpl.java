package dao;

import entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public class AppUserDAOImpl implements AppUserDAOs {


    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public AppUser save(AppUser appUser) {
        return null;
    }

    @Transactional
    @Override
    public Optional<AppUser> findById(int id) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public List<AppUser> findAll() {
        return null;
    }

    @Transactional
    @Override
    public void remove(AppUser appUser) {

    }

    @Transactional
    @Override
    public AppUser update(AppUser appUser) {
        return null;
    }

    @Transactional
    @Override
    public List<AppUser> saveAppUsers(List<AppUser> appUsers) {
        return null;
    }
}
