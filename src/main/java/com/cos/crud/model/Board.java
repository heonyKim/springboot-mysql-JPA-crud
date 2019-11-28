package com.cos.crud.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
	@ColumnDefault("0")
	private int count;
	// Many(게시글) to One(사용자) >> 하나의 사용자가 여러 게시글을 쓸 수 있음.
	// 현재 클래스가 주체가 됨
	
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
}
