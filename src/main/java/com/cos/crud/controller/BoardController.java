package com.cos.crud.controller;

import java.util.List;
import java.util.Optional;

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
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;
import com.cos.crud.utils.Script;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository mRepo;
	Script script = new Script();
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		
		List<Board> boards = mRepo.findAll();
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
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board",board.get());
		return "/board/detail";
	}
	///////////////////////////////////////////////////////////////////	
	
	@GetMapping("/board/writeForm")
	public String boardWriteForm(HttpSession session) {
		//인터셉터 처리(AOP)
		User user = (User) session.getAttribute("user"); 

		if(user !=null) {
			return "/board/writeForm";
		}else {
			return "/user/loginForm";
		}
	}
	
	@PostMapping("/board/write")
	public @ResponseBody String boardWrite(Board board,HttpSession session) {
		//인터셉터 처리(AOP)
		User user = (User) session.getAttribute("user"); 

		if(user !=null) {
			board.setUser(user);
			mRepo.save(board);
			return script.href("/board/list");
		}else {
			return script.href("/user/loginForm");
		}
		
		//redirect:/는 response.SendRedirect()랑 같음
	}
	
	///////////////////////////////////////////////////////////////////	
	
	@DeleteMapping("/board/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		//세션있어야되는데 안해
		mRepo.deleteById(id);
		return "redirect:/board/list";
	}
	///////////////////////////////////////////////////////////////////
	@GetMapping("/board/updateForm/{id}")
	public String boardUpdateFrom(@PathVariable int id,Model model) {
		//세션있어야되는데 안해
		Optional<Board> board = mRepo.findById(id);
		System.out.println(board);
		model.addAttribute("board",board.get());
		
		return "board/updateForm";
	}
	
	@PutMapping("/board/update")
	public @ResponseBody String boardUpdate(Board board,HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(board);
		if(user!=null) {
			board.setUser(user);
			mRepo.save(board);
			return script.href("/board/list");
		}else {
			return script.href("/board/loginForm");
		}
		
		
	}
	
}
