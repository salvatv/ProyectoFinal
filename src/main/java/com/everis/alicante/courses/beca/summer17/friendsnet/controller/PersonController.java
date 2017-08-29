package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonController {

	@Autowired
	private PersonManager manager;

	@GetMapping
	public List<Person> getAll() {
		return (List<Person>) manager.findAll();
	}

	@GetMapping("/{id}")
	public Person getById(@PathVariable Long id) {
		return manager.findById(id);
	}

	@PostMapping
	public Person create(@RequestBody final Person person) {
		return manager.save(person);
	}

	@PostMapping("/{id}/relate")
	public Person relate(@PathVariable Long id, @RequestBody Long id2) {
		return manager.relatePersons(id, id2);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.remove(manager.findById(id));
	}

}
