package com.cos.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;

//DB에 접속해서 자료를 가지고 오는 역할 ->서비스가 함

@Service	//메모리에 띄움
public class UserService {

	@Autowired
	private UserRepository mRepo;

	public List<User> getUser(int id) {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			users.add(mRepo.findById(id).get());
		}
		return users;
	}

	public User userLogin(User user) {
		User u = mRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return u;
	}

	// try-catch 필요. save라서
	public int userJoin(User user) {

		try {
			mRepo.save(user);
			return 1;
		} catch (Exception e) {
			System.out.println("UserJoin오류");
			e.printStackTrace();
		}
		
		return -1;
	}

}
