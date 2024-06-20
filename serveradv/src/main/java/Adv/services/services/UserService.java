package Adv.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Adv.daoRepository.UserRepository;
import Adv.models.User;
import Adv.services.iservices.UserIService;

@Service
public class UserService implements UserIService{
@Autowired
private UserRepository rep;

@Override
public ResponseEntity<String> add(User u) {
		if(rep.existsById(u.getEmail()))
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists"); 
		rep.save(u);
		 return ResponseEntity.ok("User added successfully");}

@Override
public boolean find(String email, String password) {
	User u=rep.findById(email).get();
	if(u!=null&&u.getPassword().equals(password))
		return true;
	return false;
}

@Override
public List<User> getAll() {
List<User>lu=new ArrayList<>();
rep.findAll().forEach(u->lu.add(u));
return lu;



}
}


