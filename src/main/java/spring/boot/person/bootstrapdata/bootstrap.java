package spring.boot.person.bootstrapdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.boot.person.domain.Person;
import spring.boot.person.service.PersonCrudService;

@ComponentScan("spring.boot.person.bootstrapdata")
@Configuration
public class bootstrap implements CommandLineRunner {

    private final PersonCrudService personCrudService;

    public bootstrap(PersonCrudService personCrudService) {
        this.personCrudService = personCrudService;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person =new Person();
        person.setId((long)15);
        person.setFirstName("Michael");
        personCrudService.save(person);
        System.out.println(personCrudService.findPersonById((long)15));

    }
}
