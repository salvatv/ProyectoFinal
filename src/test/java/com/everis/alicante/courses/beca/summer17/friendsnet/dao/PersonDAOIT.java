package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class PersonDAOIT {

    @Autowired
    private PersonDAO dao;

    private ObjectMapper mapper;

    @Before
    public void setup() {
        this.mapper = new ObjectMapper();
    }


    @Test
    @DatabaseSetup("/db/initial-person.xml")
    public void testFindAll() throws JSONException {
        // Act
        List<Person> all = (List<Person>) dao.findAll();

        // Assert
        Assert.assertEquals(2, all.size());
    }

    @Test
    @DatabaseSetup("/db/initial-person.xml")
    public void testSavePerson() throws JSONException {
        // Arrange
        final Person person = new Person();
        person.setName("A");
        person.setSurname("B");

        // Act
        dao.save(person);

        // Assert
        List<Person> all = (List<Person>) dao.findAll();
        Assert.assertEquals(3, all.size());
    }


    @Test
    @DatabaseSetup("/db/initial-person.xml")
    @ExpectedDatabase(value = "/db/after-saving-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSavePerson2() throws JSONException {
        // Arrange
        final Person person = new Person();
        person.setName("A");
        person.setSurname("B");

        // Act
        dao.save(person);
    }


    @Test
    @DatabaseSetup("/db/initial-person.xml")
    @ExpectedDatabase(value = "/db/after-saving-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemovePerson() throws JSONException {
        // Arrange
        Person person = dao.findById(2L);

        // Act
        dao.remove(person);

        // Assert
        List<Person> all = (List<Person>) dao.findAll();
        Assert.assertEquals(1, all.size());
    }

}
