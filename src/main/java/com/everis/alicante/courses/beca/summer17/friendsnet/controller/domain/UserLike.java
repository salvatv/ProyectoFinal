package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import com.everis.alicante.courses.beca.summer17.friendsnet.enums.LikeType;
import lombok.Data;

@Data
public class UserLike {

	private Long idUser;
	private LikeType likeType;
}