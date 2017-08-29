package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;

@Service
public class GroupManagerImpl implements GroupManager {

	@Autowired
	private GroupDAO groupDAO;

	@Autowired
	private PersonDAO personDAO;

	@Override
	public Iterable<Group> findAll() {
		return groupDAO.findAll();
	}

	@Override
	public Group findById(Long id) {
		return groupDAO.findOne(id);
	}

	@Override
	public Group save(Group e) {
		return groupDAO.save(e);
	}

	@Override
	public Iterable<Group> saveAll(Iterable<Group> e) {
		return groupDAO.save(e);
	}

	@Override
	public Group update(Group e) {
		return groupDAO.save(e);
	}

	@Override
	public Iterable<Group> update(Iterable<Group> e) {
		return groupDAO.save(e);
	}

	@Override
	public void remove(Group e) {
		groupDAO.delete(e);;

	}

	@Override
	public Group relateGroup(Long idGroup, Long idPerson) {
		final Person person = personDAO.findOne(idPerson);
		final Group group = groupDAO.findOne(idGroup);
		group.getGroups().add(person);
		return groupDAO.save(group);
	}

}
