package com.cos.crud.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30)
	private String username;
	
	@Column(length = 30)
	private String password;
	
	private String phone;
	private String email;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@ColumnDefault("'user'")
	private String role;

	//연관관계의 주인은 ForeignKey를 가진 쪽이다
	//@JsonManagedReference는 콜렉션이 있는쪽에 걸어줌
//	@JsonManagedReference
//	@JsonIgnore
//	@OneToMany(mappedBy = "user")
//	private List<Board> boards;
}
