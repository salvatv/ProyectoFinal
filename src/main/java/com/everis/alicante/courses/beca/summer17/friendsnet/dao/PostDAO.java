package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;

@Service
public interface PostDAO extends CrudRepository<Post, Long> {

}
