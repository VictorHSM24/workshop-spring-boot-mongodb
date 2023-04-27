package com.victor.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.workshopmongo.domain.User;
import com.victor.workshopmongo.dto.UserDTO;
import com.victor.workshopmongo.repository.UserRepository;
import com.victor.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> optionalUser = repo.findById(id);
		User user = optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return user;
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		User user = findById(id);
		repo.delete(user);
	}
	
	public User update(User obj) {
		Optional<User> optionalNewObj = repo.findById(obj.getId());
		User newObj = optionalNewObj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}