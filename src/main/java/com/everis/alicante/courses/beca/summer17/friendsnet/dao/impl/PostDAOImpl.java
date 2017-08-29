package com.everis.alicante.courses.beca.summer17.friendsnet.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;

@Service
public class PostDAOImpl extends AbstractDAO<Post, Long> implements PostDAO {

	@Override
	public Post addLike(Long id, Like like) {
		Post post = this.findById(id);
		Set<Like> likes = post.getLikes();
		likes.add(like);		
		post.setLikes(likes);
		return this.save(post);

	}

}
