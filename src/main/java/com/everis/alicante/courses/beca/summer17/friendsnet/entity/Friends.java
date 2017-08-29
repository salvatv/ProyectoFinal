//package com.everis.alicante.courses.beca.summer17.friendsnet.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "friendsTable")
//public class Friends implements FNEntity {
//
//	@Id	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "friends_id", nullable = false, unique = true)
//	private Long id;
//
//	@ManyToOne
//	@JoinColumn(name = "person_id", nullable=false,unique=true)
//	private Person friends;
//}
