package spring.boot.person.service;

import spring.boot.person.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonCrudService<T,ID> {
    List<T> findAllPerson();
    Optional<Person> findPersonById(Long id);
    public void deletePersonById(Long id);
    public void deletePerson(Person person);
    public <S extends Person> S save(S person);
    public T getPersonById(Long id);
}
