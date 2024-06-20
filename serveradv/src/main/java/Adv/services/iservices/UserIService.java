//package Adv.services.IServices;
//
//import java.util.List;
//
//import Adv.models.User;
//
//public interface IUserService {
//	boolean add(User u);
//	boolean find(String email, String password);
//	List<User> getAll();
//}
package Adv.services.iservices;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Adv.models.User;

public interface UserIService{
	ResponseEntity<String> add(User u);
	boolean find(String email,String password);
	List<User> getAll();
}

