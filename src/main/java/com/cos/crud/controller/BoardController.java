package com.cos.crud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.service.BoardService;
import com.cos.crud.utils.Script;

@Controller
public class BoardController {

	@Autowired
	private BoardService mService;
	Script script = new Script();
	
	////////////트랜잭션 테스트//////////////
	@PostMapping("/ict/{id}")
	public @ResponseBody String increaseCountAndTimeUpdate(@PathVariable int id) {
		mService.increaseCountAndTimeUpdate(id);
		return "test완료";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		
		List<Board> boards = mService.boardList();
		model.addAttribute("boards",boards);
		return "/board/list";
	}
//	
//	@GetMapping("/board/list/{id}")
//	public @ResponseBody List<Board> boardList(@PathVariable int id) {
//		
//		List<Board> boards = mRepo.findAll();
//		return boards;
//	}
	
	
	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id, Model model) {
		
		//결과값이 Null로 나올 수 있으므로 Optional로 감싸면 Null이 안나옴
		Board board = mService.boardDetail(id);
		model.addAttribute("board",board);
		return "/board/detail";
	}
	
	
	
	///////////////////////////////////////////////////////////////////	
	
	@GetMapping("/board/writeForm")
	public String boardWriteForm() {
		return "/board/writeForm";

	}
	
	@PostMapping("/board/write")
	public String boardWrite(Board board,HttpSession session) {
		int result = mService.boardWrite(board, session);
		
		if(result ==1) {
			return "redirect:/board/list";
		}else {
			return "/board/writeForm";
		}
	}
	
	
	///////////////////////////////////////////////////////////////////	
	
	@DeleteMapping("/board/delete/{id}")
	public @ResponseBody String boardDelete(@PathVariable int id) {

		int result=mService.boardDelete(id);
		if(result==1) {
			return script.href("/board/list");
		}else {
			return script.back("삭제 실패");
		}

		
	}
	///////////////////////////////////////////////////////////////////
	@GetMapping("/board/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id,Model model) {

		Board board = mService.boardUpdateForm(id);
		model.addAttribute("board",board);
		
		return "board/updateForm";
	}
	
	@PutMapping("/board/update")
	public @ResponseBody String boardUpdate(Board board,HttpSession session) {
		
		int result = mService.boardUpdate(board, session);
		
		if(result ==1) {
			return script.href("/board/list");
		}else {
			return script.backHref("업데이트 실패", "/board/list");
		}
	}
	
}
