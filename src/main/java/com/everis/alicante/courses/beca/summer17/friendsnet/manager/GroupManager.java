package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;

public interface GroupManager extends Manager<Group, Long> {

	Group relateGroup(Long idGroup, Long idPerson);

}
