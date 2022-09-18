package se.lexicon.exercise_relational_mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.exercise_relational_mapping.data.repository.AddressRepository;
import se.lexicon.exercise_relational_mapping.data.repository.StatusRepository;
import se.lexicon.exercise_relational_mapping.data.repository.AppUserRepository;
import se.lexicon.exercise_relational_mapping.data.repository.CarRepository;
import se.lexicon.exercise_relational_mapping.entity.Address;
import se.lexicon.exercise_relational_mapping.entity.AppUser;
import se.lexicon.exercise_relational_mapping.entity.Car;
import se.lexicon.exercise_relational_mapping.entity.Status;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


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


    private StatusRepository statusRepository;

    private AddressRepository addressRepository;

    private AppUserRepository appUserRepository;

    private CarRepository carRepository;

    private EntityManager entityManager;

    @Autowired
    public MyCommandLineRunner(StatusRepository statusRepository, AddressRepository addressRepository, AppUserRepository appUserRepository, CarRepository carRepository, EntityManager entityManager) {
        this.statusRepository = statusRepository;
        this.addressRepository = addressRepository;
        this.appUserRepository = appUserRepository;
        this.carRepository = carRepository;
        this.entityManager = entityManager;
    }

    public MyCommandLineRunner() {
    }

    @Override
    public void run(String... args) {


        System.out.println("This is CommandLineRunner ");
        Address address1 = new Address(1, "Admiral ", "13477", "Victoria");

        address1 = addressRepository.save(address1);
        entityManager.persist(address1);



        AppUser user1 = new AppUser("user1@email.com", "namedUser1", "ssWWbb", address1);
        user1 = appUserRepository.save(user1);
        entityManager.persist(user1);
        user1.setAddress(address1);

        AppUser user2 = new AppUser("user2@email.com", "namedUser2", "sdddd", address1);
        user2 = appUserRepository.save(user2);
        entityManager.persist(user2);


        Car car1 = new Car("123abc", "KIA", "Creed", LocalDate.now(), user1);
        car1 = carRepository.save(car1);
        entityManager.persist(car1);
        car1.setOwner(user1);


        Car car2 = new Car("321cba", "Mercede", "c200", LocalDate.now(), user2);
        car2 = carRepository.save(car2);
        entityManager.persist(car2);


        Car car3= new Car("456xyz","BMW","X1",LocalDate.parse("2022-09-10"),user2);
        car2 = carRepository.save(car2);
        entityManager.persist(car2);



        Collection<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
        Status status1 = new Status("Pending", cars);
        status1 = statusRepository.save(status1);
        entityManager.persist(status1);


        entityManager.flush();

    }


}





