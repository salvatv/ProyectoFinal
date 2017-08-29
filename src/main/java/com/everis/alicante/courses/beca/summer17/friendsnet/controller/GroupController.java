package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@RestController
@RequestMapping("/group")
@Transactional
public class GroupController {

	@Autowired
	private GroupManager manager;
	
	@Autowired
	private PersonManager personManager;


	@GetMapping
	public List<Group> getAll() {
		return (List<Group>) manager.findAll();
	}

	@GetMapping("/{id}")
	public Group getById(@PathVariable Long id) {
		return manager.findById(id);
	}

	@PostMapping
	public Group create(@RequestBody Group e) {
		return manager.save(e);
	}

	public Set<Group> getByPersonId(Long id) {
		
		Person person = personManager.findById(id);
		return person.getGroups();
		
	}

	@PostMapping("/{idGroup}/relateGroup")
	public Group relateGroup(@PathVariable Long idGroup, @RequestBody Long idPerson) {
		return manager.relateGroup(idGroup, idPerson);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.remove(manager.findById(id));
	}
}
