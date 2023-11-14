package com.nurserygarden.ecommerceapp.entities_demo.repositories;

import com.nurserygarden.ecommerceapp.entities_demo.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
