package com.cos.crud.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.cos.crud.model.Board;


//CRUD를 구현해주는 클래스 : JpaRePository
public interface BoardRepository extends JpaRepository<Board, Integer>{


	
}
