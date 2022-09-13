package se.lexicon.exercise_relational_mapping;

import dao.AddressDAOs;
import dao.AppUserDAOs;
import entity.Address;
import entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@ComponentScan("dao")
@EnableAutoConfiguration
@SpringBootConfiguration
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);

    }

    @Transactional
    @Component
    class MyCommandLineRunner implements CommandLineRunner {


        private final AppUserDAOs appUserDAOs;
        private final AddressDAOs addressDAOs;
        private final EntityManager entityManager;

        @Autowired
        public MyCommandLineRunner(AppUserDAOs appUserDAOs, AddressDAOs addressDAOs, EntityManager entityManager) {
            this.appUserDAOs = appUserDAOs;
            this.addressDAOs = addressDAOs;
            this.entityManager = entityManager;
        }

        @Override
        public void run(String... args) throws Exception {


            System.out.println("This is Nothing ");

            Address address1 = null;
            AppUser user1 = new AppUser("user1@email.com", "namedUser1", "ssWWbb", address1);

            user1 = appUserDAOs.save(user1);

            address1 = new Address(1, "Admiral ", "13477", "Victoria");

            entityManager.persist(address1);
            user1.setAddress(address1);


            entityManager.flush();

            System.out.println("user1 = " + user1);


        }


    }
}




