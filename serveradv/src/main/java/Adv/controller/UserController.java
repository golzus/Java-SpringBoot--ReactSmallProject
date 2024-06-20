package Adv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Adv.models.User;
import Adv.services.iservices.UserIService;
@CrossOrigin(origins="http://localhost:3000")

@RestController
public class UserController{
 @Autowired
 private UserIService ser;
 @PostMapping("/users/add")
 public ResponseEntity<String> add(@RequestBody User u) {
	 return ser.add(u);
 } 
@PostMapping("/users/find")
public boolean find(@RequestBody User u) {
	return ser.find(u.getEmail(), u.getPassword());
}
@GetMapping("/users")
	public List<User> getAll(){
		return ser.getAll();
	}

}


