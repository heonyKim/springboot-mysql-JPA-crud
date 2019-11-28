package com.cos.crud.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository mRepo;
	
	////////////트랜잭션 테스트//////////////
	@Transactional	//무조건 catch에서 RuntimeException으로 던져야 트랜잭션을 잡을 수 있음
	public void increaseCountAndTimeUpdate(int id) {
		
		try {
			mRepo.increaseCount(id);
			mRepo.timeUpdate(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	

	public List<Board> boardList() {
		List<Board> boards = mRepo.findAll();
		return boards;
	}

	

	public Board boardDetail(int id) {
		
		Optional<Board> board = mRepo.findById(id);
		return board.get();
	}

	

	public int boardWrite(Board board, HttpSession session) {

		try {
			User user = (User) session.getAttribute("user"); 
			board.setUser(user);
			mRepo.save(board);
			return 1;
		} catch (Exception e) {
			System.out.println("boardWrite 오류");
			e.printStackTrace();
		}
		return -1;
	}


	public int boardDelete(int id) {
		
		try {
			mRepo.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardDelete 오류");
		}
		return -1;	
	}
	
	
	public Board boardUpdateForm(int id) {

		Optional<Board> board = mRepo.findById(id);
		return board.get();	
	}
	
	
	
	public int boardUpdate(Board board,HttpSession session) {
		
		try {
			User user = (User) session.getAttribute("user");
			board.setUser(user);
			mRepo.save(board);
			return 1;
		} catch (Exception e) {

		}
		return -1;
	}
	
	
}
