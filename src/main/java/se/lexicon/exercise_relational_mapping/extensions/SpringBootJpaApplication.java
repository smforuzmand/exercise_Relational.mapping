package se.lexicon.exercise_relational_mapping.extensions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.exercise_relational_mapping.data.dao.AddressDAOs;
import se.lexicon.exercise_relational_mapping.data.dao.AppUserDAOs;
import se.lexicon.exercise_relational_mapping.data.repository.StatusRepository;
import se.lexicon.exercise_relational_mapping.entity.Address;
import se.lexicon.exercise_relational_mapping.entity.AppUser;

import javax.persistence.EntityManager;


@SpringBootApplication
public class SpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);

        System.out.println("Main!");
    }
}

@Transactional
@ComponentScan
class MyCommandLineRunner implements CommandLineRunner {

   /* private final AppUserDAOs appUserDAOs;
    private final AddressDAOs addressDAOs;
    private final EntityManager entityManager;*/

    private StatusRepository statusRepository;

    @Autowired
    public MyCommandLineRunner(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

//    @Autowired
//    public MyCommandLineRunner(AppUserDAOs appUserDAOs, AddressDAOs addressDAOs, EntityManager entityManager) {
//        this.appUserDAOs = appUserDAOs;
//        this.addressDAOs = addressDAOs;
//        this.entityManager = entityManager;
//
//
//    }

    @Override
    public void run(String... args) {


        System.out.println("This is CommandLineRunner ");

      /*  Address address1 = new Address(1, "Admiral ", "13477", "Victoria");
        address1 = addressDAOs.save(address1);

        AppUser user1 = new AppUser("user1@email.com", "namedUser1", "ssWWbb", address1);
        user1 = appUserDAOs.save(user1);*/



    }


}





