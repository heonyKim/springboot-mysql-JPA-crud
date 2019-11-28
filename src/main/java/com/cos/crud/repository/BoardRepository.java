package com.cos.crud.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.crud.model.Board;


//CRUD를 구현해주는 클래스 : JpaRePository
public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	// update할때는 Transactional, Modifying
	// insert할때는 Transactional
	// delete할때는 Transactional
	////////////트랜잭션 테스트//////////////
	@Transactional
	@Modifying
	@Query(value = "UPDATE board SET count=count+1 WHERE id=?1", nativeQuery = true)
	public void increaseCount(int id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE board SET createDate=now() WHERE id=?1", nativeQuery = true)
	public void timeUpdate(int id);
	
}
