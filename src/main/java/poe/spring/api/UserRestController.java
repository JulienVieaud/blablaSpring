package poe.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.User;
import poe.spring.services.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {


	@Autowired
	UserManagerService userManagerService;

	//CREATE
	@PostMapping
	public User save(@RequestBody User user) {

		User savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
		System.out.println("user id sqsq: " + savedUser);
		return savedUser;
	}
	
	//READ
	@GetMapping
	public List<User> read(){
		List<User> usersList = userManagerService.readUsers();
		System.out.println("Read");
		return usersList;
	}

}
