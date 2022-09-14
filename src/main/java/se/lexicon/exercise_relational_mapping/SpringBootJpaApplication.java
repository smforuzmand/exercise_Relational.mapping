package se.lexicon.exercise_relational_mapping;

import dao.AddressDAOs;
import dao.AppUserDAOs;
import entity.Address;
import entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@ComponentScan("dao")
@SpringBootApplication
public class SpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);

        System.out.println("Main!");
    }
}

@Transactional
@Component
class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(AppUserDAOs appUserDAOs, AddressDAOs addressDAOs, EntityManager entityManager) {
        this.appUserDAOs = appUserDAOs;
        this.addressDAOs = addressDAOs;
        this.entityManager = entityManager;
    }

    private final AppUserDAOs appUserDAOs;
    private final AddressDAOs addressDAOs;
    private final EntityManager entityManager;

    @Override
    public void run(String... args) {


        System.out.println("This is CommandLineRunner ");

        Address address1 = new Address(1, "Admiral ", "13477", "Victoria");

        entityManager.persist(address1);

        AppUser user1 = new AppUser("user1@email.com", "namedUser1", "ssWWbb", address1);

        user1 = appUserDAOs.save(user1);


        user1.setAddress(address1);


        entityManager.flush();

        System.out.println("user1 = " + user1);


    }


}





