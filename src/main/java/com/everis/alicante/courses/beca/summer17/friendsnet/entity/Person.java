package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, exclude={"friends", "groups", "events"})
@Entity
@Table(name = "persons")
public class Person implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private Long id;

	private String name;

	private String surname;

	private byte[] picture;

	@ManyToMany(mappedBy = "groups")
	@JsonIgnore
	private Set<Group> groups;

	// @OneToMany(mappedBy = "friends")
	// @JsonIgnore
	// private final Set<Person> friends = new HashSet<>();

	// **************
	// testing

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "friends", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {@JoinColumn(name = "friend_id") })
	@JsonIgnore
	private Set<Person> friends;

	@ManyToMany(mappedBy = "friends")
	@JsonIgnore
	private Set<Person> friend;

	// ************
	// endtest

	@OneToMany(mappedBy = "likes")
	@JsonIgnore
	private Set<Like> likes;

	@OneToMany(mappedBy = "posts")
	@JsonIgnore
	private Set<Post> posts;

	@ManyToMany(mappedBy = "events")
	@JsonIgnore
	private Set<Event> events;

}

