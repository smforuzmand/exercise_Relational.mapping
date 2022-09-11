package se.lexicon.exercise_relational_mapping;

import entity.AppUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("The second part of JPA exercise");

        AppUser appUser = new AppUser();




    }
}
