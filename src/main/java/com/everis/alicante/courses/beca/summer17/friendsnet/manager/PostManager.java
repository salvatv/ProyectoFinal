package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.enums.LikeType;

public interface PostManager extends Manager<Post, Long> {

	public Like addLike(Long id, Long idUser, LikeType likeType);

}
