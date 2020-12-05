package spring.boot.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.person.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
