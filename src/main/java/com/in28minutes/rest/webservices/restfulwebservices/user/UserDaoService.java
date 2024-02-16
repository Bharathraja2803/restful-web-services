package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Vijay",LocalDate.now().minusYears(50)));
		users.add(new User(2,"Ajith",LocalDate.now().minusYears(45)));
		users.add(new User(3,"Surya",LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
}
