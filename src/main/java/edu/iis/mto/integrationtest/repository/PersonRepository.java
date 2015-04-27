package edu.iis.mto.integrationtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iis.mto.integrationtest.model.Person;



public interface PersonRepository extends JpaRepository<Person, Long>{


}
