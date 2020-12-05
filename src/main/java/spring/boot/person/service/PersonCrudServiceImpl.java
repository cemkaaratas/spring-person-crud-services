package spring.boot.person.service;

import org.springframework.stereotype.Service;
import spring.boot.person.domain.Person;
import spring.boot.person.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonCrudServiceImpl<T, ID> implements PersonCrudService<Person, Long> {

    private final PersonRepository personRepository;

    public PersonCrudServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public Optional<Person> findPersonById(Long along) {
        return personRepository.findById(along);
    }

    @Override
    public void deletePersonById(Long along) {
        personRepository.deleteById(along);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public <S extends Person> S save(S person) {
        return personRepository.save(person);
    }


}
