package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.UserLike;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostManager manager;

	@Autowired
	PersonManager personManager;

	@GetMapping
	public List<Post> getAll() {
		List<Post> posts = (List<Post>) manager.findAll();
		return posts;
	}

	@GetMapping("/{id}")
	public Post getById(@RequestParam Long id) {
		return (Post) manager.findById(id);
	}

	@PostMapping
	public Post create(@RequestBody final Post post) {
		return manager.save(post);
	}

	@PostMapping("/{idPost}/like")
	public Like addLike(@PathVariable Long idPost, @RequestBody UserLike userLike) {
		return manager.addLike(idPost, userLike.getIdUser(), userLike.getLikeType());

	}

	@DeleteMapping("/{id}")
	public void remove(@RequestParam Long id) {
		manager.remove(manager.findById(id));
	}

}
