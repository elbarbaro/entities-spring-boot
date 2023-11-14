package com.nurserygarden.ecommerceapp.entities_demo.repositories;

import com.nurserygarden.ecommerceapp.entities_demo.entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
