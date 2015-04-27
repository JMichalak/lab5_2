package edu.iis.mto.integrationtest.repository;

import static edu.iis.mto.integrationtest.repository.PersonBuilder.person;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import edu.iis.mto.integrationtest.model.Person;


public class PersonRepositoryIntegrationTest extends IntegrationTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	@DirtiesContext
	public void testCanAccessDbAndGetTestData() {
		List<Person> foundTestPersons = personRepository.findAll();
		assertEquals(2, foundTestPersons.size());
	}

	@Test
	@DirtiesContext
	public void testSaveNewPersonAndCheckIsPersisted() {
		long count = personRepository.count();
		personRepository.save(a(person().withId(count + 1)
				.withFirstName("Roberto").withLastName("Mancini")));
		assertEquals(count + 1, personRepository.count());
		assertEquals("Mancini", personRepository.findOne(count + 1)
				.getLastName());
	}
	@Test
	@DirtiesContext
	public void testDeletesAllPeople(){
		long count = personRepository.count();
		personRepository.deleteAll();
		count = personRepository.count();
		assertEquals(0,count);
	}
	
	private Person a(PersonBuilder builder) {
		return builder.build();
	}

}
