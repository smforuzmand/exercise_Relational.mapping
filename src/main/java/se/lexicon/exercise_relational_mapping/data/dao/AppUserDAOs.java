package se.lexicon.exercise_relational_mapping.data.dao;

import se.lexicon.exercise_relational_mapping.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDAOs {

    AppUser save(AppUser appUser);

    Optional<AppUser> findById(int id);

    List<AppUser> findAll();

    void remove(AppUser appUser);

    AppUser update(AppUser appUser);

    List<AppUser> saveAppUsers(List<AppUser> appUsers);




}
