package net.javaguides.sb_test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sb_test.entity.User;
import net.javaguides.sb_test.exception.ResourceNotFoundException;
import net.javaguides.sb_test.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> getAll(){
		return this.userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(
	@PathVariable(value="id")long id){
		return this.userRepository.findById(id)
								  .orElseThrow(()-> new ResourceNotFoundException("El usuario "+id+" no existe"));
	}
	
	@PostMapping
	public User create(@Valid @RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	@PutMapping("/{id}")
	public User update(@Valid @RequestBody User user, @PathVariable("id") long id) {
		User existing =  this.userRepository.findById(id)
				  			 .orElseThrow(()-> new ResourceNotFoundException("El usuario "+id+" no existe"));
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setEmail(user.getEmail());
		return this.userRepository.save(existing);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable("id")long id){
		User existing =  this.userRepository.findById(id)
	  			 .orElseThrow(()-> new ResourceNotFoundException("El usuario "+id+" no existe"));
		this.userRepository.delete(existing);
		return ResponseEntity.ok().build();
		
	}
	
}
