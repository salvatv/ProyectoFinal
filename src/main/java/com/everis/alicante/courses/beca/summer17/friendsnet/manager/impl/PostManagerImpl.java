package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.LikeDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.enums.LikeType;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;

@Service
public class PostManagerImpl implements PostManager {

	@Autowired
	PostDAO dao;

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private LikeDAO likeDAO;

	@Override
	public Iterable<Post> findAll() {
		return dao.findAll();
	}

	@Override
	public Post findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Post save(Post e) {
		return dao.save(e);
	}

	@Override
	public Iterable<Post> saveAll(Iterable<Post> e) {
		return dao.save(e);
	}

	@Override
	public Post update(Post e) {
		return dao.save(e);
	}

	@Override
	public Iterable<Post> update(Iterable<Post> e) {
		return dao.save(e);
	}

	@Override
	public void remove(Post e) {
		dao.delete(e);

	}

	@Override
	public Like addLike(Long id, Long idUser, LikeType likeType) {
		final Post post = dao.findOne(id);
		final Person person = personDAO.findOne(idUser);
		final Like like = new Like();
		like.setLikes(person);
		like.setLikesByPost(post);
		like.setType(likeType);
		return likeDAO.save(like);
	}

}
