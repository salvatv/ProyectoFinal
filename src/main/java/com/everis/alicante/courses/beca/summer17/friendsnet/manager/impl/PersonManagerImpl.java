package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@Service
public class PersonManagerImpl implements PersonManager {

	@Autowired
	private PersonDAO dao;

	@Override
	public Iterable<Person> findAll() {
		return dao.findAll();
	}

	@Override
	public Person findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Person save(Person e) {
		return dao.save(e);
	}

	@Override
	public Iterable<Person> saveAll(Iterable<Person> e) {
		return dao.save(e);

	}

	@Override
	public Person update(Person e) {
		return dao.save(e);
	}

	@Override
	public Iterable<Person> update(Iterable<Person> e) {
		return dao.save(e);
	}

	@Override
	public void remove(Person e) {
		dao.save(e);
	}

	@Override
	public Person relatePersons(Long idperson, Long idfriend) {
		final Person person = dao.findOne(idperson);
		final Person friend = dao.findOne(idfriend);
		person.getFriends().add(friend);
		friend.getFriends().add(person);
		return dao.save(person);

	}

}
